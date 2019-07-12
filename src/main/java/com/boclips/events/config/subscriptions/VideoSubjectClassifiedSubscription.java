package com.boclips.events.config.subscriptions;

import com.boclips.events.config.TopicConstants;
import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

public interface VideoSubjectClassifiedSubscription {
    String CHANNEL = TopicConstants.VIDEO_SUBJECT_CLASSIFIED + TopicConstants.SUBSCRIPTION_SUFFIX;

    @Input(CHANNEL)
    SubscribableChannel channel();
}
