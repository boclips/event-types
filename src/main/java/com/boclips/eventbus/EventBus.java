package com.boclips.eventbus;

public interface EventBus {
    <T> void subscribe(Class<T> eventType, EventHandler<? super T> eventHandler, String methodName);

    void unsubscribe(Class<?> eventType);

    <T> void publish(Iterable<T> events);

    <T> void publish(T event);
}
