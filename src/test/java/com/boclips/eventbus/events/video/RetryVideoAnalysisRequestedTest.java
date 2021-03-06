package com.boclips.eventbus.events.video;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Locale;

import static org.assertj.core.api.Assertions.assertThat;

class RetryVideoAnalysisRequestedTest {

    @Test
    public void objectMapperCanParseJsonIntoRetryVideoToAnalyse() throws IOException {
        String json = "{ \"videoId\": \"123\", \"videoUrl\": \"http://example.com/abc\" }";

        RetryVideoAnalysisRequested videoToAnalyse = new ObjectMapper().readValue(json, RetryVideoAnalysisRequested.class);

        assertThat(videoToAnalyse.getVideoId()).isEqualTo("123");
        assertThat(videoToAnalyse.getVideoUrl()).isEqualTo("http://example.com/abc");
        assertThat(videoToAnalyse.getLanguage()).isNull();
    }

    @Test
    public void objectMapperCanParseJsonWithLanguage() throws IOException {
        String json = "{ \"videoId\": \"\", \"videoUrl\": \"\", \"language\": \"en_US\" }";

        RetryVideoAnalysisRequested videoToAnalyse = new ObjectMapper().readValue(json, RetryVideoAnalysisRequested.class);

        assertThat(videoToAnalyse.getLanguage()).isEqualTo(Locale.US);
    }

    @Test
    void objectMapperSerializesLanguageAsStringCode() throws JsonProcessingException {
        RetryVideoAnalysisRequested videoToAnalyse = RetryVideoAnalysisRequested.builder().videoId("id").videoUrl("url").language(Locale.UK).build();

        String json = new ObjectMapper().writeValueAsString(videoToAnalyse);

        assertThat(json).contains("\"language\":\"en_GB\"");
    }
}
