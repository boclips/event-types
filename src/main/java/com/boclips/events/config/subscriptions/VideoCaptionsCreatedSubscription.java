package com.boclips.events.config.subscriptions;

import com.boclips.events.config.TopicConstants;
import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

public interface VideoCaptionsCreatedSubscription {
    String CHANNEL = TopicConstants.VIDEO_CAPTIONS_CREATED + TopicConstants.SUBSCRIPTION_SUFFIX;

    @Input(CHANNEL)
    SubscribableChannel channel();
}
