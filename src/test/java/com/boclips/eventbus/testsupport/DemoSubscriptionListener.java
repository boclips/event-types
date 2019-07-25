package com.boclips.eventbus.testsupport;

import com.boclips.eventbus.BoclipsEventListener;
import org.springframework.stereotype.Component;

@Component
public class DemoSubscriptionListener {

    private TestEvent event;

    public TestEvent getEvent() {
        return event;
    }

    @BoclipsEventListener
    public void onMessage(TestEvent event) {
        this.event = event;
    }
}
