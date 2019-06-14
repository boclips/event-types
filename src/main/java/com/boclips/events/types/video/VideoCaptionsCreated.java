package com.boclips.events.types.video;

import com.boclips.events.types.Captions;
import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class VideoCaptionsCreated {

    @NonNull
    private String videoId;

    @NonNull
    private Captions captions;
}
