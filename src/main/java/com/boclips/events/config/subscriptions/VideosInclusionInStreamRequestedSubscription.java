package com.boclips.events.config.subscriptions;

import com.boclips.events.config.TopicConstants;
import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

public interface VideosInclusionInStreamRequestedSubscription {
    String CHANNEL = TopicConstants.VIDEOS_INCLUSION_IN_STREAM_REQUESTED + TopicConstants.SUBSCRIPTION_SUFFIX;

    @Input(CHANNEL)
    SubscribableChannel channel();
}
