package com.boclips.eventbus.events.user;

import com.boclips.eventbus.domain.user.User;
import com.boclips.eventbus.infrastructure.EventSerializer;
import org.junit.jupiter.api.Test;

import static java.util.Collections.emptyList;
import static org.assertj.core.api.Assertions.assertThat;

class UserExpiredTest {
    @Test
    void userExpired_canBeDeserialized() {
        UserExpired event = UserExpired.builder()
                .user(User.builder().id("user-id").isBoclipsEmployee(false).subjects(emptyList()).ages(emptyList()).build())
                .build();
        EventSerializer serializer = new EventSerializer();

        Object deserializedEvent = serializer.deserialise(event, serializer.serialise(event));

        assertThat(deserializedEvent).isEqualTo(event);
    }

}
