package com.boclips.eventbus.events.video;

import com.boclips.eventbus.BoclipsEvent;
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
