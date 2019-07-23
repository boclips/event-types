package com.boclips.eventbus;

public interface EventBus {
    <T> void subscribe(Class<T> eventType, EventHandler<T> eventHandler, ExceptionHandlingPolicy exceptionHandlingPolicy);

    default <T> void subscribe(Class<T> eventType, EventHandler<T> eventHandler) {
        subscribe(eventType, eventHandler, ExceptionHandlingPolicy.NO_RETRY);
    }

    void unsubscribe(Class<?> eventType);
    void publish(Object event);
}
