package com.boclips.events.types;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class VideoToAnalyse {

    @NonNull
    private String videoId;

    @NonNull
    private String videoUrl;
}
