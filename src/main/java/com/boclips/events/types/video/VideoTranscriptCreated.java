package com.boclips.events.types.video;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class VideoTranscriptCreated {

    @NonNull
    private String videoId;

    @NonNull
    private String transcript;
}
