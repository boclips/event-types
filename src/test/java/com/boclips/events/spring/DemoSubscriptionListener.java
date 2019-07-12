package com.boclips.events.spring;

import com.boclips.events.config.subscriptions.VideoAnalysisRequestedSubscription;
import org.springframework.cloud.stream.annotation.StreamListener;

public class DemoSubscriptionListener {

    private String message;

    @StreamListener(VideoAnalysisRequestedSubscription.CHANNEL)
    public void receiveMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
