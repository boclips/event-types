package com.boclips.events.config;

import com.boclips.events.config.legacy.BoclipsMessagingConfiguration;
import com.boclips.events.config.legacy.TopicConstants;
import org.junit.jupiter.api.Test;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.cloud.stream.config.BindingProperties;
import org.springframework.cloud.stream.config.BindingServiceProperties;
import org.springframework.messaging.MessageChannel;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class BoclipsMessagingConfigurationTest {

    @Test
    void configuresTopicChannels() {
        BindingServiceProperties properties = new BoclipsMessagingConfiguration().forContext(MessagingContext.class);

        BindingProperties topicProperties = properties.getBindings().get("analysed-videos-topic");

        assertThat(topicProperties.getDestination()).isEqualTo("analysed-videos");
        assertThat(topicProperties.getGroup()).isNull();
    }

    @Test
    void throwsIfContextClassNotAnnotatedWithEnableBinding() {
        assertThrows(Exception.class, () -> new BoclipsMessagingConfiguration().forContext(InvalidContext.class));
    }

    static class InvalidContext {
    }

    @EnableBinding({Topics.class})
    public static class MessagingContext {

    }

    interface Topics {
        @Output("analysed-videos-topic")
        MessageChannel analysedVideos();
    }
}
