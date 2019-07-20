package com.boclips.eventbus.infrastructure;

import com.boclips.eventbus.EventBus;
import com.boclips.eventbus.EventHandler;

import java.util.HashMap;
import java.util.Map;

public class SynchronousEventBus implements EventBus {
    private Map<Class<?>, EventHandler<?>> handlerByEvent = new HashMap<>();

    @Override
    public <T> void subscribe(Class<T> eventType, EventHandler<T> eventHandler) {
        handlerByEvent.put(eventType, eventHandler);
    }

    @Override
    @SuppressWarnings("unchecked")
    public void publish(Object event) {
        EventHandler<Object> eventHandler = (EventHandler<Object>) handlerByEvent.get(event.getClass());
        eventHandler.handle(event);
    }
}
