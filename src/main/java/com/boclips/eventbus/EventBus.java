package com.boclips.eventbus;

import com.boclips.eventbus.config.EventListener;

public interface EventBus {

    void subscribe(EventListener eventListener);

    void publish(Object event);
}
