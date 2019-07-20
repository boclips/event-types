package com.boclips.events.types.video;

import com.boclips.events.BoclipsEvent;
import lombok.*;

import java.util.Locale;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@BoclipsEvent("video-analysis-requested")
public class VideoAnalysisRequested {

    @NonNull
    private String videoId;

    @NonNull
    private String videoUrl;

    private Locale language;
}
