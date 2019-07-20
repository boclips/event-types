package com.boclips.eventbus;

public interface EventHandler<T> {
    void handle(T event);
}
