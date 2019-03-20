package com.boclips.eventtypes;

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
