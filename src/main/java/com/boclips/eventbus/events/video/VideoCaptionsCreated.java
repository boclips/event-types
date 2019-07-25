package com.boclips.eventbus.events.video;

import com.boclips.eventbus.BoclipsEvent;
import com.boclips.eventbus.domain.video.Captions;
import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@BoclipsEvent("video-captions-created")
public class VideoCaptionsCreated {

    @NonNull
    private String videoId;

    @NonNull
    private Captions captions;
}
