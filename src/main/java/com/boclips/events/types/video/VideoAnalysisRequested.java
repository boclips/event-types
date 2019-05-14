package com.boclips.events.types.video;

import lombok.*;

import java.util.Locale;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class VideoAnalysisRequested {

    @NonNull
    private String videoId;

    @NonNull
    private String videoUrl;

    private Locale language;
}
