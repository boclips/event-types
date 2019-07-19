package com.boclips.events.config;

import com.boclips.events.config.legacy.TopicDetector;
import com.boclips.events.config.legacy.TopicInfo;
import org.junit.jupiter.api.Test;
import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;

import java.util.Set;

import static java.util.stream.Collectors.toList;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class BoclipsEventDetectorTest {

    @Test
    void extractsTestFromTopicChannels() {
        Set<TopicInfo> topics = TopicDetector.scanTopicChannels(TestTopics.class);

        assertThat(topics.stream().map(TopicInfo::getTopicName).collect(toList())).containsExactlyInAnyOrder("first", "second");
        assertThat(topics.stream().map(TopicInfo::getChannelName).collect(toList())).containsExactlyInAnyOrder("first-topic", "second-topic");
    }

    @Test
    void extractsTopicsFromSubscriptionChannels() {
        Set<TopicInfo> topics = TopicDetector.scanSubscriptionChannels(TestSubscriptions.class);

        assertThat(topics.stream().map(TopicInfo::getTopicName).collect(toList())).containsExactlyInAnyOrder("one", "another");
        assertThat(topics.stream().map(TopicInfo::getChannelName).collect(toList())).containsExactlyInAnyOrder("one-subscription", "another-subscription");
    }

    @Test
    void throwsWhenTopicChannelLacksTheExpectedSuffix() {
        assertThrows(Exception.class, () -> TopicDetector.scanTopicChannels(InvalidChannelNames.class));
    }

    @Test
    void throwsWhenSubscriptionChannelLacksTheExpectedSuffix() {
        assertThrows(Exception.class, () -> TopicDetector.scanSubscriptionChannels(InvalidChannelNames.class));
    }

    interface TestTopics {

        @Output("first-topic")
        MessageChannel oneTopic();

        @Output("second-topic")
        MessageChannel anotherTopic();
    }

    interface TestSubscriptions {

        @Input("one-subscription")
        SubscribableChannel firstSubscription();

        @Input("another-subscription")
        SubscribableChannel anotherSubscription();
    }

    interface InvalidChannelNames {

        @Output("first")
        MessageChannel oneTopic();

        @Input("one")
        SubscribableChannel firstSubscription();
    }
}
