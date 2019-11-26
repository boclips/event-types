package com.boclips.eventbus.infrastructure;

import com.boclips.eventbus.ConflictingSubscriberException;
import com.boclips.eventbus.EventBus;
import com.boclips.eventbus.EventHandler;
import com.boclips.eventbus.config.EventConfigurationExtractor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;
import java.util.stream.Collectors;

public class SynchronousFakeEventBus implements EventBus {
    private Map<Class<?>, EventHandler<?>> handlerByEvent = new HashMap<>();
    private List<Object> allEvents = new ArrayList<>();
    private final EventSerializer serializer = new EventSerializer();

    @Override
    public <T> void subscribe(Class<T> eventType, EventHandler<T> eventHandler) {
        handlerByEvent.computeIfPresent(eventType, (cls, handler) -> {
            throw new ConflictingSubscriberException("There already is a subscription for " + eventType.getSimpleName() + ": " + handler.getClass().getSimpleName());
        });
        handlerByEvent.put(eventType, eventHandler);
        Logger.getLogger(SynchronousFakeEventBus.class.getSimpleName()).info("Subscribed handler for " + eventType);
    }

    @Override
    public <T> void publish(Iterable<T> events) {
        events.forEach(this::publish);
    }

    @Override
    @SuppressWarnings("unchecked")
    public <T> void publish(T event) {
        new EventConfigurationExtractor().getEventName(event.getClass());

        allEvents.add(event);
        byte[] eventBytes = serializer.serialise(event);

        EventHandler<Object> eventHandler = (EventHandler<Object>) handlerByEvent.get(event.getClass());
        if (eventHandler != null) {
            eventHandler.handle(serializer.deserialise(event, eventBytes));
        }

        Logger.getLogger(SynchronousFakeEventBus.class.getSimpleName()).info("Published event " + event.getClass());
    }

    @Override
    public void unsubscribe(Class<?> eventType) {
        handlerByEvent.remove(eventType);
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
