package com.boclips.eventbus.events.video;

import com.boclips.eventbus.infrastructure.ObjectMapperProvider;
import com.boclips.eventbus.testsupport.TestWithJsonFixture;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;

class VideoSegmentPlayedTest extends TestWithJsonFixture {

    @Test
    void playback() throws IOException {
        String json = "{" +
                "\"videoId\": \"video-id-123\"," +
                "\"segmentStartSeconds\": \"2\"," +
                "\"segmentEndSeconds\": \"10\"," +
                "\"query\": \"cats are awesomer than dogs\"," +
                "\"userId\": \"user-id\"" +
                "}";

        VideoSegmentPlayed event = ObjectMapperProvider.get().readValue(json, VideoSegmentPlayed.class);

        assertThat(event.getVideoId()).isEqualTo("video-id-123");
        assertThat(event.getSegmentStartSeconds()).isEqualTo(2);
        assertThat(event.getSegmentEndSeconds()).isEqualTo(10);
        assertThat(event.getQuery()).isEqualTo("cats are awesomer than dogs");
        assertThat(event.getUserId()).isEqualTo("user-id");
    }
}
