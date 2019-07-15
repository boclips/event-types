package com.boclips.events.spring;

import com.boclips.events.config.Topics;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.UUID;

import static java.util.concurrent.TimeUnit.SECONDS;
import static org.assertj.core.api.Assertions.assertThat;
import static org.awaitility.Awaitility.await;

@ActiveProfiles("test")
@SpringBootTest(classes = {DemoApplication.class, DemoSubscriptionListener.class})
@ExtendWith(SpringExtension.class)
public class PubSubMessageRoundTripIntegrationTest {

    @Autowired
    Topics topics;

    @Autowired
    DemoSubscriptionListener demoSubscriptionListener;

    @Test
    void pubSubTest() {
        String message = UUID.randomUUID().toString();

        topics.videoAnalysisRequested().send(MessageBuilder.withPayload(message).build());

        await().atMost(20, SECONDS).untilAsserted(() ->
                assertThat(demoSubscriptionListener.getMessage()).isEqualTo(message)
        );
    }
}
