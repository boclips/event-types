package com.boclips.eventtypes;

import lombok.Builder;
import lombok.Data;
import lombok.NonNull;

@Data
@Builder
public class VideoToAnalyse {

    @NonNull
    private final String videoId;

    @NonNull
    private final String videoUrl;
}
