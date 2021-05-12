package com.boclips.eventbus.events.page;

import com.boclips.eventbus.infrastructure.ObjectMapperProvider;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;

public class PageRenderedTest {
    @Test
    void pageRenderedWithoutViewport() throws IOException {
        String json = "{" +
                "\"userId\": \"user-123\"," +
                "\"url\": \"http://localhost/hello\"" +
                "}";

        PageRendered event = ObjectMapperProvider.get().readValue(json, PageRendered.class);

        assertThat(event.getUserId()).isEqualTo("user-123");
        assertThat(event.getUrl()).isEqualTo("http://localhost/hello");
        assertThat(event.getViewport()).isNull();
    }

    @Test
    void pageRenderedWithViewport() throws IOException {
        String json = "{" +
                "\"userId\": \"user-123\"," +
                "\"url\": \"http://localhost/hello\"," +
                "\"viewport\": {\"width\": \"360\", \"height\": \"640\"}" +
                "}";

        PageRendered event = ObjectMapperProvider.get().readValue(json, PageRendered.class);

        assertThat(event.getUserId()).isEqualTo("user-123");
        assertThat(event.getUrl()).isEqualTo("http://localhost/hello");
        assertThat(event.getViewport().getWidth()).isEqualTo(360);
        assertThat(event.getViewport().getHeight()).isEqualTo(640);
    }

    @Test
    void pageRenderedWithResizeSet() throws IOException {
        String json = "{" +
                "\"userId\": \"user-123\"," +
                "\"url\": \"http://localhost/hello\"," +
                "\"isResize\": true" +
                "}";

        PageRendered event = ObjectMapperProvider.get().readValue(json, PageRendered.class);

        assertThat(event.getUserId()).isEqualTo("user-123");
        assertThat(event.getUrl()).isEqualTo("http://localhost/hello");
        assertThat(event.getIsResize()).isTrue();
    }

}
