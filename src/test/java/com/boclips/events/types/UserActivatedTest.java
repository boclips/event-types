package com.boclips.events.types;

import com.fasterxml.jackson.core.JsonProcessingException;
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
                .user(User.builder().id("id").email("email").build())
                .totalUsers(10L)
                .activatedUsers(3L)
                .build();

        assertThat(userActivated.getTimestamp()).isToday();
    }

    @Test
    void timestampGetsSetWhenDeserialising() throws IOException {
        Date timestamp = Date.from(ZonedDateTime.now(ZoneOffset.UTC).plusDays(1).toInstant());

        UserActivated userActivated = UserActivated.builder()
                .user(User.builder().id("id").email("email").build())
                .totalUsers(10L)
                .activatedUsers(3L)
                .timestamp(timestamp)
                .build();

        ObjectMapper om = new ObjectMapper();
        String json = om.writeValueAsString(userActivated);

        assertThat(om.readValue(json, UserActivated.class).getTimestamp()).isEqualTo(timestamp);
    }
}
