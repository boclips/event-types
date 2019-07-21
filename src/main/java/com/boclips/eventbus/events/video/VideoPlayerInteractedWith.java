package com.boclips.eventbus.events.video;

import com.boclips.eventbus.BoclipsEvent;
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
