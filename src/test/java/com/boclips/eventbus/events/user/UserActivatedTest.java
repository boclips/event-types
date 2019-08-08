package com.boclips.eventbus.events.user;

import com.boclips.eventbus.domain.user.Organisation;
import com.boclips.eventbus.domain.user.User;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.util.Date;

import static org.assertj.core.api.Assertions.assertThat;

class UserActivatedTest {

    @Test
    void timestampIsSetAutomatically() {
        UserActivated userActivated = UserActivated.builder()
                .user(User.builder().id("id").isBoclipsEmployee(true).build())
                .totalUsers(10L)
                .activatedUsers(3L)
                .build();

        assertThat(userActivated.getTimestamp()).isToday();
    }

    @Test
    void timestampGetsSetWhenDeserialising() throws IOException {
        Date timestamp = Date.from(ZonedDateTime.now(ZoneOffset.UTC).plusDays(1).toInstant());

        UserActivated userActivated = UserActivated.builder()
                .user(User.builder().id("id").isBoclipsEmployee(true).build())
                .totalUsers(10L)
                .activatedUsers(3L)
                .timestamp(timestamp)
                .build();

        ObjectMapper om = new ObjectMapper();
        String json = om.writeValueAsString(userActivated);

        assertThat(om.readValue(json, UserActivated.class).getTimestamp()).isEqualTo(timestamp);
    }

    @Test
    void organisationIsNullIfUserDoesNotBelongToOne() {
        UserActivated userActivated = UserActivated.builder()
                .user(
                        User.builder()
                                .id("id")
                                .isBoclipsEmployee(true)
                                .build()
                )
                .totalUsers(10L)
                .activatedUsers(3L)
                .build();

        assertThat(userActivated.getUser().getOrganisation()).isNull();
    }

    @Test
    void organisationIsSetAccordinglyIfUserBelongsToOne() {
        String organisationId = "test-organisation-id";
        UserActivated userActivated = UserActivated.builder()
                .user(
                        User.builder()
                                .id("id")
                                .organisation(Organisation.builder()
                                        .id(organisationId)
                                        .build()
                                )
                                .isBoclipsEmployee(true)
                                .build()
                )
                .totalUsers(10L)
                .activatedUsers(3L)
                .build();

        assertThat(userActivated.getUser().getOrganisation().getId()).isEqualTo(organisationId);
    }
}
