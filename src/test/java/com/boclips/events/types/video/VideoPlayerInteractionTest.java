package com.boclips.events.types.video;

import com.boclips.events.types.TestWithJsonFixture;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;

class VideoPlayerInteractionTest extends TestWithJsonFixture {

    @Test
    void fullscreenOn() throws IOException {
        String json = "{" +
                "\"type\":\"fullscreen-on\"," +
                "\"playerId\":\"player-id-123\"," +
                "\"videoId\": \"video-id-123\"," +
                "\"videoDurationSeconds\":120" +
                "}";

        VideoPlayerInteraction event = new ObjectMapper().readValue(json, VideoPlayerInteraction.class);

        assertThat(event.getType()).isEqualTo("fullscreen-on");
        assertThat(event.getPayload()).isNotNull();
        assertThat(event.getPayload().isEmpty()).isTrue();
    }

    @Test
    void captionsOn() throws IOException {
        String json = "{" +
                "\"type\":\"captions-on\"," +
                "\"playerId\":\"player-id-123\"," +
                "\"videoId\": \"video-id-123\"," +
                "\"videoDurationSeconds\":120," +
                "\"payload\": {" +
                    "\"kind\": \"caption-kind\"," +
                    "\"label\": \"caption-label\"," +
                    "\"language\": \"caption-language\"," +
                    "\"id\": \"caption-id\"" +
                "}" +
            "}";

        VideoPlayerInteraction event = new ObjectMapper().readValue(json, VideoPlayerInteraction.class);

        assertThat(event.getType()).isEqualTo("captions-on");
        assertThat(event.getPayload()).isNotNull();
        assertThat(event.getPayload().isEmpty()).isFalse();
        assertThat(event.getPayload().get("kind")).isEqualTo("caption-kind");
        assertThat(event.getPayload().get("label")).isEqualTo("caption-label");
        assertThat(event.getPayload().get("language")).isEqualTo("caption-language");
        assertThat(event.getPayload().get("id")).isEqualTo("caption-id");
    }

}
