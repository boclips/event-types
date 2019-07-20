package com.boclips.events.types.video;

import com.boclips.events.BoclipsEvent;
import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@BoclipsEvent("video-transcript-created")
public class VideoTranscriptCreated {

    @NonNull
    private String videoId;

    @NonNull
    private String transcript;
}
