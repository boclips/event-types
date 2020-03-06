package com.boclips.eventbus.infrastructure;

import com.boclips.eventbus.ConflictingSubscriberException;
import com.boclips.eventbus.EventHandler;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;
import java.util.stream.Collectors;

public class SynchronousFakeEventBus extends AbstractEventBus {
    private Map<String, EventHandler<?>> handlerByTopic = new HashMap<>();
    private List<Object> allEvents = new ArrayList<>();
    private final EventSerializer serializer = new EventSerializer();

    @Override
    public <T> void doSubscribe(String topicName, Class<T> eventType, EventHandler<T> eventHandler) {
        handlerByTopic.computeIfPresent(topicName, (cls, handler) -> {
            throw new ConflictingSubscriberException("There already is a subscription for " + eventType.getSimpleName() + ": " + handler.getClass().getSimpleName());
        });
        handlerByTopic.put(topicName, eventHandler);
        Logger.getLogger(SynchronousFakeEventBus.class.getSimpleName()).info("Subscribed: " + topicName);
    }

    @Override
    @SuppressWarnings("unchecked")
    protected void doPublish(Iterable<?> events, String topicName) {
        EventHandler<Object> eventHandler = (EventHandler<Object>) handlerByTopic.get(topicName);
        events.forEach(event -> {
            allEvents.add(event);
            byte[] eventBytes = serializer.serialise(event);
            if (eventHandler != null) {
                eventHandler.handle(serializer.deserialise(event, eventBytes));
            }
            Logger.getLogger(SynchronousFakeEventBus.class.getSimpleName()).info("Published event: " + topicName);
        });
    }

    @Override
    public void doUnsubscribe(String topicName) {
        handlerByTopic.remove(topicName);
    }

    public <T> Boolean hasReceivedEventOfType(Class<T> eventType) {
        List<T> eventsOfType = getEventsOfType(eventType);
        return eventsOfType.size() != 0;
    }

    public <T> T getEventOfType(Class<T> eventType) {
        List<T> eventsOfType = getEventsOfType(eventType);

        if (eventsOfType.size() == 0) {
            throw new IllegalStateException("Found 0 events matching " + eventType);
        }

        if (eventsOfType.size() > 1) {
            throw new IllegalStateException(String.format("Found more than one (%d) events matching {%s}", eventsOfType.size(), eventType));
        }

        return eventsOfType.stream().findFirst().get();
    }

    public void clearState() {
        allEvents.clear();
    }

    public List<Object> getReceivedEvents() {
        return allEvents;
    }

    public int countEventsOfType(Class<?> eventType) {
        return getEventsOfType(eventType).size();
    }

    @SuppressWarnings("unchecked")
    public <T> List<T> getEventsOfType(Class<T> eventType) {
        return allEvents.stream()
                .filter(eventType::isInstance)
                .map(event -> (T) event)
                .collect(Collectors.toList());
    }
}
