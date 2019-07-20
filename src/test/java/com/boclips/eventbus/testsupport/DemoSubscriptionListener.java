package com.boclips.eventbus.testsupport;

import com.boclips.eventbus.BoclipsEventListener;
import com.boclips.eventbus.events.video.VideoUpdated;
import org.springframework.stereotype.Component;

@Component
public class DemoSubscriptionListener {

    private VideoUpdated message;

    public VideoUpdated getMessage() {
        return message;
    }

    @BoclipsEventListener
    public void onMessage(VideoUpdated message) {
        this.message = message;
    }
}
