package com.boclips.eventbus;

import com.boclips.eventbus.events.video.VideoUpdated;

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