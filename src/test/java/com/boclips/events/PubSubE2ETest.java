package com.boclips.events;

import com.boclips.events.config.legacy.Topics;
import com.boclips.events.types.video.VideoUpdated;
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
@SpringBootTest(classes = DemoApplication.class)
@ExtendWith(SpringExtension.class)
public class PubSubE2ETest {

    @Autowired
    Topics topics;

    @Autowired
    DemoSubscriptionListener demoSubscriptionListener;

    @Test
    void pubSubTest() {
        VideoUpdated message = VideoUpdated.builder()
                .videoId(UUID.randomUUID().toString())
                .title("the title")
                .contentPartnerName("the content partner")
                .build();

        topics.videoUpdated().send(MessageBuilder.withPayload(message).build());

        await().atMost(20, SECONDS).untilAsserted(() ->
                assertThat(demoSubscriptionListener.getMessage()).isEqualTo(message)
        );
    }
}
