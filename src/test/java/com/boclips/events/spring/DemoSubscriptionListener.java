package com.boclips.events.spring;

import com.boclips.events.config.Subscriptions;
import com.boclips.events.config.TopicNames;
import org.springframework.cloud.stream.annotation.StreamListener;

public class DemoSubscriptionListener {

    private String message;

    @StreamListener(Subscriptions.VIDEOS_TO_ANALYSE)
    public void receiveMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
