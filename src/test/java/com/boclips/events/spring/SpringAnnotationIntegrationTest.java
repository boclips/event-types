package com.boclips.events.spring;

import com.boclips.events.config.Topics;
import com.boclips.events.config.subscriptions.VideoAnalysisRequestedSubscription;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.stream.test.binder.MessageCollector;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.assertj.core.api.Assertions.assertThat;

@ActiveProfiles("test")
@SpringBootTest(classes = {DemoApplication.class, DemoSubscriptionListener.class})
@ExtendWith(SpringExtension.class)
@AutoConfigureMockMvc
public class SpringAnnotationIntegrationTest {

    @Autowired
    MessageCollector messageCollector;

    @Autowired
    Topics topics;

    @Autowired
    VideoAnalysisRequestedSubscription videoAnalysisRequestedSubscription;

    @Autowired
    DemoSubscriptionListener demoSubscriptionListener;

    @Test
    void publishMessagesToTopics() {
        pushMessageIntoTopic("hello");

        Message<?> message = messageCollector.forChannel(topics.videoAnalysisRequested()).poll();

        assertThat(message).isNotNull();
    }

    @Test
    void receivingMessagesFromSubscriptions() {
        assertThat(demoSubscriptionListener.getMessage()).isNull();

        pushMessageIntoSubscription("hello");

        assertThat(demoSubscriptionListener.getMessage()).isEqualTo("hello");
    }

    private void pushMessageIntoTopic(String message) {
        topics.videoAnalysisRequested().send(MessageBuilder.withPayload(message).build());
    }

    private void pushMessageIntoSubscription(String message) {
        videoAnalysisRequestedSubscription.channel().send(MessageBuilder.withPayload(message).build());
    }
}
