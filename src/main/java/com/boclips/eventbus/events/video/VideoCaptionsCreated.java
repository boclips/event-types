package com.boclips.eventbus.events.video;

import com.boclips.eventbus.BoclipsEvent;
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
