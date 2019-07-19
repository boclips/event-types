package com.boclips.events;

import com.boclips.events.BoclipsEventListener;
import com.boclips.events.types.video.VideoUpdated;

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
