package com.boclips.eventbus.events.user;

import com.boclips.eventbus.domain.user.User;
import com.boclips.eventbus.infrastructure.EventSerializer;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class UserCreatedTest {

    @Test
    void userCreated_canBeDeserialized() {
        UserCreated event = UserCreated.builder()
                .user(User.builder().id("user-id").isBoclipsEmployee(false).build())
                .build();
        EventSerializer serializer = new EventSerializer();

        Object deserializedEvent = serializer.deserialise(event, serializer.serialise(event));

        assertThat(deserializedEvent).isEqualTo(event);
    }
}
