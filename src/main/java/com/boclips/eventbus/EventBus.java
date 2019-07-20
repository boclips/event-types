package com.boclips.eventbus;

public interface EventBus {

    <T> void subscribe(Class<T> eventType, EventHandler<T> eventHandler);

    void publish(Object event);
}
