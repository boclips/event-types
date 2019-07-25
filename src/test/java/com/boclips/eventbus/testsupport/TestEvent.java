package com.boclips.eventbus.testsupport;

import com.boclips.eventbus.BoclipsEvent;

@BoclipsEvent("test-event")
public class TestEvent {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
