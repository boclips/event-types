package com.boclips.eventbus.events.user;

import com.boclips.eventbus.domain.user.User;
import com.boclips.eventbus.domain.user.UserProfile;
import com.boclips.eventbus.infrastructure.EventSerializer;
import org.junit.jupiter.api.Test;

import java.time.ZoneId;
import java.time.ZonedDateTime;

import static java.util.Collections.emptyList;
import static org.assertj.core.api.Assertions.assertThat;

class UserCreatedTest {

    @Test
    void userCreated_canBeDeserialized() {
        User user = User.builder()
                .id("user-id")
                .createdAt(ZonedDateTime.now(ZoneId.of("UTC")))
                .isBoclipsEmployee(false)
                .profile(UserProfile.builder()
                        .subjects(emptyList())
                        .ages(emptyList())
                        .hasOptedIntoMarketing(true)
                        .build())
                .build();
        UserCreated event = UserCreated.builder()
                .user(user)
                .build();
        EventSerializer serializer = new EventSerializer();

        Object deserializedEvent = serializer.deserialise(event, serializer.serialise(event));

        assertThat(deserializedEvent).isEqualTo(event);
    }
}
