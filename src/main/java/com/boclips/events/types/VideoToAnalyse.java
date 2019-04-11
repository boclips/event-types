package com.boclips.events.types;

import lombok.*;

import java.util.Locale;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class VideoToAnalyse {

    @NonNull
    private String videoId;

    @NonNull
    private String videoUrl;

    private Locale language;
}
