package com.boclips.eventbus.events.user;

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
                .userId("abc")
                .build();

        assertThat(userActivated.getTimestamp()).isToday();
    }

    @Test
    void timestampGetsSetWhenDeserialising() throws IOException {
        Date timestamp = Date.from(ZonedDateTime.now(ZoneOffset.UTC).plusDays(1).toInstant());

        UserActivated userActivated = UserActivated.builder()
                .userId("abc")
                .timestamp(timestamp)
                .build();

        ObjectMapper om = new ObjectMapper();
        String json = om.writeValueAsString(userActivated);

        assertThat(om.readValue(json, UserActivated.class).getTimestamp()).isEqualTo(timestamp);
    }

}
