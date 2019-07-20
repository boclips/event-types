package com.boclips.events.types.video;

import com.boclips.events.BoclipsEvent;
import com.boclips.events.types.Captions;
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
