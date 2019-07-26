package com.boclips.eventbus;

public interface EventBus {
    <T> void subscribe(Class<T> eventType, EventHandler<T> eventHandler);
    void unsubscribe(Class<?> eventType);
    <T> void publish(Iterable<T> event);
    <T> void publish(T event);
}
