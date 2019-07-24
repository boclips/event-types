package com.boclips.eventbus;

import com.boclips.eventbus.events.video.VideoUpdated;
import com.boclips.eventbus.testsupport.AbstractPubSubTest;
import com.boclips.eventbus.testsupport.DemoSubscriptionListener;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Collections;
import java.util.UUID;

import static java.util.concurrent.TimeUnit.SECONDS;
import static org.assertj.core.api.Assertions.assertThat;
import static org.awaitility.Awaitility.await;

public class SpringAutoconfigurationPubSubTest extends AbstractPubSubTest {

    @Autowired
    EventBus eventBus;

    @Autowired
    DemoSubscriptionListener demoSubscriptionListener;

    @Test
    void pubSubTest() {
        VideoUpdated event = VideoUpdated.builder()
                .videoId(UUID.randomUUID().toString())
                .title("the title")
                .contentPartnerName("the content partner")
                .subjects(Collections.emptyList())
                .build();

        eventBus.publish(event);

        await().atMost(5, SECONDS).untilAsserted(() ->
                assertThat(demoSubscriptionListener.getMessage()).isEqualTo(event)
        );
    }
}
