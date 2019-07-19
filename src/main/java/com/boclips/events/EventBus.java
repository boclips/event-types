package com.boclips.events;

import com.boclips.events.config.EventListener;

public interface EventBus {

    void subscribe(EventListener eventListener);

    void publish(Object event);
}
