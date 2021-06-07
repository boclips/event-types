package com.boclips.eventbus.infrastructure;

import com.boclips.eventbus.config.BoclipsEventsProperties;
import com.boclips.eventbus.config.InvalidMessagingConfiguration;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Base64;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class PubSubEventBusTest {

    BoclipsEventsProperties properties;

    @BeforeEach
    void setUp() {
        properties = new BoclipsEventsProperties();
        properties.setConsumerGroup("some-group");
        properties.setProject("some-project-id");
        properties.setSecret(new String(Base64.getDecoder().decode("blah")));
    }

    @Test
    public void throwsWhenProjectIdIsNull() {
        assertThatThrownBy(() -> {
            properties.setProject(null);
            new PubSubEventBus(properties);
        }).hasMessage("PUBSUB_PROJECT must be defined");
    }

    @Test
    public void throwsWhenConsumerGroupIsNull() {
        assertThatThrownBy(() -> {
            properties.setConsumerGroup(null);
            new PubSubEventBus(properties);
        }).hasMessage("PUBSUB_CONSUMER_GROUP must be defined");
    }
}
