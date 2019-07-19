package com.boclips.events.infrastructure;

import com.boclips.events.config.BoclipsEventsProperties;
import com.boclips.events.config.InvalidMessagingConfiguration;
import com.boclips.events.infrastructure.PubSubEventBus;
import com.fasterxml.jackson.databind.ObjectMapper;
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
            new PubSubEventBus(properties, new ObjectMapper());
        }).hasMessage("PUBSUB_PROJECT_ID must be defined");
    }

    @Test
    public void throwsWhenConsumerGroupIsNull() {
        assertThatThrownBy(() -> {
            properties.setConsumerGroup(null);
            new PubSubEventBus(properties, new ObjectMapper());
        }).hasMessage("PUBSUB_CONSUMER_GROUP must be defined");
    }

    @Test
    public void throwsWhenCredentialsNotSet() {
        assertThatThrownBy(() -> {
            properties.setSecret(null);
            new PubSubEventBus(properties, new ObjectMapper());
        }).hasMessage("PUBSUB_SECRET must be defined");
    }

    @Test
    public void throwsWhenSecretIsNotBase64Encoded() {
        assertThatThrownBy(() -> {
            properties.setSecret("not a valid base64");
            new PubSubEventBus(properties, new ObjectMapper());
        })
                .isInstanceOf(InvalidMessagingConfiguration.class)
                .hasMessage("PUBSUB_SECRET is not a base64-encoded string");
    }

}
