package com.boclips.eventbus;

import java.util.HashSet;
import java.util.Set;

public class TestEventBusExtensions implements EventBus {

    private final EventBus eventBus;

    private final Set<Class<?>> testSubscriberEventTypes;

    public TestEventBusExtensions(EventBus eventBus) {
        this.eventBus = eventBus;
        this.testSubscriberEventTypes = new HashSet<>();
    }

    @Override
    public <T> void subscribe(Class<T> eventType, EventHandler<T> eventHandler) {
        eventBus.subscribe(eventType, eventHandler);
    }

    public <T> TestEventHandler<T> subscribe(Class<T> eventType) {
        TestEventHandler<T> eventHandler = new TestEventHandler<>();
        subscribe(eventType, eventHandler);
        testSubscriberEventTypes.add(eventType);
        return eventHandler;
    }

    @Override
    public void publish(Object event) {
        eventBus.publish(event);
    }

    @Override
    public void unsubscribe(Class<?> eventType) {
        eventBus.unsubscribe(eventType);
    }

    public void unsubscribeTestHandlers() {
        testSubscriberEventTypes.forEach(this::unsubscribe);
        testSubscriberEventTypes.clear();
    }
}
