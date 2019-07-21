package com.boclips.eventbus.events.video;

import com.boclips.eventbus.events.video.VideoPlaybackSyncRequested;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;

class VideoPlaybackSyncRequestedTest {
    @Test
    public void objectMapperCanParseJson() throws IOException {
        String json = "{ \"videoId\": \"123\" }";

        VideoPlaybackSyncRequested event = new ObjectMapper().readValue(json, VideoPlaybackSyncRequested.class);

        assertThat(event.getVideoId()).isEqualTo("123");
    }

}
