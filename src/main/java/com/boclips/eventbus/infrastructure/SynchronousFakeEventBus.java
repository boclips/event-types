package com.boclips.eventbus.infrastructure;

import com.boclips.eventbus.ConflictingSubscriberException;
import com.boclips.eventbus.EventBus;
import com.boclips.eventbus.EventHandler;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;
import java.util.stream.Collectors;

public class SynchronousFakeEventBus implements EventBus {
    private Map<Class<?>, EventHandler<?>> handlerByEvent = new HashMap<>();
    private List<Object> allEvents = new ArrayList<>();
    private final ObjectMapper objectMapper = ObjectMapperProvider.get();

    @Override
    public <T> void subscribe(Class<T> eventType, EventHandler<T> eventHandler) {
        handlerByEvent.computeIfPresent(eventType, (cls, handler) -> {
            throw new ConflictingSubscriberException("There already is a subscription for " + eventType.getSimpleName() + ": " + handler.getClass().getSimpleName());
        });
        handlerByEvent.put(eventType, eventHandler);
        Logger.getLogger(SynchronousFakeEventBus.class.getSimpleName()).info("Subscribed handler for " + eventType);
    }

    @Override
    @SuppressWarnings("unchecked")
    public <T> void publish(Iterable<T> events) {
        events.forEach(this::publish);
    }

    @Override
    @SuppressWarnings("unchecked")
    public <T> void publish(T event) {
        allEvents.add(event);
        byte[] eventBytes = serialise(event);

        EventHandler<Object> eventHandler = (EventHandler<Object>) handlerByEvent.get(event.getClass());
        if (eventHandler != null) {
            eventHandler.handle(deserialise(event, eventBytes));
        }

        Logger.getLogger(SynchronousFakeEventBus.class.getSimpleName()).info("Published event " + event.getClass());
    }

    private byte[] serialise(Object event) {
        try {
            return objectMapper.writeValueAsBytes(event);
        } catch (JsonProcessingException e) {
            throw new RuntimeException("Failed serialising event: " + event);
        }
    }

    private Object deserialise(Object event, byte[] eventBytes) {
        try {
            return objectMapper.readValue(eventBytes, event.getClass());
        } catch (IOException e) {
            throw new RuntimeException("Failed de-serialising event: " + event);
        }
    }

    @Override
    public void unsubscribe(Class<?> eventType) {
        handlerByEvent.remove(eventType);
    }

    public Boolean hasReceivedEventOfType(Class<?> eventType) {
        List<Object> eventsOfType = getEventsOfType(eventType);
        return eventsOfType.size() != 0;
    }

    public <T> T getEventOfType(Class<T> eventType) {
        List<Object> eventsOfType = getEventsOfType(eventType);

        if (eventsOfType.size() == 0) {
            throw new IllegalStateException("Found 0 events matching " + eventType);
        }

        if (eventsOfType.size() > 1) {
            throw new IllegalStateException(String.format("Found more than one (%d) events matching {%s}", eventsOfType.size(), eventType));
        }

        return (T) eventsOfType.stream().findFirst().get();
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

    public <T> List<T> getEventsOfType(Class<?> eventType) {
        @SuppressWarnings("unchecked")
        List<T> events = (List<T>) allEvents.stream().filter(object -> object.getClass() == eventType).collect(Collectors.toList());
        return events;
    }
}
