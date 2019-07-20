package com.boclips.events.types.video;

import com.boclips.events.BoclipsEvent;
import com.boclips.events.types.base.VideoPlayerEvent;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.HashMap;
import java.util.Map;

@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@BoclipsEvent("video-player-interacted-with")
public class VideoPlayerInteractedWith extends VideoPlayerEvent {

    @NonNull
    private Number currentTime;

    @NonNull
    private String subtype;

    private Map<String, Object> payload = new HashMap<>();

}
