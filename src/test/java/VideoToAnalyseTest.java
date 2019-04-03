import com.boclips.events.types.VideoToAnalyse;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;

class VideoToAnalyseTest {

    @Test
    public void objectMapperCanParseJsonIntoVideoToAnalyse() throws IOException {
        String json = "{ \"videoId\": \"123\", \"videoUrl\": \"http://example.com/abc\" }";

        VideoToAnalyse videoToAnalyse = new ObjectMapper().readValue(json, VideoToAnalyse.class);

        assertThat(videoToAnalyse.getVideoId()).isEqualTo("123");
        assertThat(videoToAnalyse.getVideoUrl()).isEqualTo("http://example.com/abc");
    }
}