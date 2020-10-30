package com.boclips.eventbus.events.video;

import com.boclips.eventbus.infrastructure.ObjectMapperProvider;
import com.boclips.eventbus.testsupport.TestWithJsonFixture;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;

class VideosSearchedTest extends TestWithJsonFixture {

    @Test
    void fromJson() throws IOException {
        String json = "{" +
                "\"pageSize\": 1," +
                "\"pageIndex\": 2," +
                "\"pageVideoIds\": [\"video-id-1\"]," +
                "\"query\": \"hurr durr\"," +
                "\"userId\": \"user-id\"," +
                "\"queryParams\": {\"duration\": [\"0M-2M\"], \"age_range\": [\"9-11\",\"16-18\"]}" +
                "}";

        VideosSearched event = ObjectMapperProvider.get().readValue(json, VideosSearched.class);

        assertThat(event.getQuery()).isEqualTo("hurr durr");
        assertThat(event.getUserId()).isEqualTo("user-id");
        assertThat(event.getPageVideoIds()).containsExactly("video-id-1");
        assertThat(event.getPageIndex()).isEqualTo(2);
        assertThat(event.getPageSize()).isEqualTo(1);
        assertThat(event.getQueryParams().get("duration")).containsExactly("0M-2M");
        assertThat(event.getQueryParams().get("age_range")).containsExactly("9-11", "16-18");
    }
}
