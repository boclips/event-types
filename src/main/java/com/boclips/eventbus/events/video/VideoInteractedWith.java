package com.boclips.eventbus.events.video;

import com.boclips.eventbus.BoclipsEvent;
import com.boclips.eventbus.events.base.AbstractUserEvent;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.HashMap;
import java.util.Map;

@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@BoclipsEvent("video-interacted-with")
public class VideoInteractedWith extends AbstractUserEvent {

    @NonNull
    private String videoId;

    @NonNull
    private String subtype;

    @NonNull
    @Builder.Default
    private Map<String, Object> payload = new HashMap<>();
}
