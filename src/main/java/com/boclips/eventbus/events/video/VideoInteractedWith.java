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
@BoclipsEvent("video-interacted-with")
public class VideoInteractedWith extends AbstractVideoEvent {

    @NonNull
    private String subtype;

    private Map<String, Object> payload = new HashMap<>();
}
