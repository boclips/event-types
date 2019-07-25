package com.boclips.eventbus;

import com.boclips.eventbus.testsupport.AbstractPubSubTest;
import com.boclips.eventbus.testsupport.DemoSubscriptionListener;
import com.boclips.eventbus.testsupport.TestEvent;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

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

        TestEvent event = new TestEvent();
        event.setName("hello");

        eventBus.publish(event);

        await().atMost(5, SECONDS).untilAsserted(() -> {
                    TestEvent receivedEvent = demoSubscriptionListener.getEvent();
                    assertThat(receivedEvent).isNotNull();
                    assertThat(receivedEvent.getName()).isEqualTo("hello");
                }
        );
    }

}
