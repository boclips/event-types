package com.boclips.events.types.video;

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
public class VideoPlayerInteraction extends VideoPlayerEvent {

    @NonNull
    private Number currentTime;

    @NonNull
    private String type;

    private Map<String, Object> payload = new HashMap<>();

}
