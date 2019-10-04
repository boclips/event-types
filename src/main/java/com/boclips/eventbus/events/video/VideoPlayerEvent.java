package com.boclips.eventbus.events.video;

import com.boclips.eventbus.events.base.AbstractEventWithUserId;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class VideoPlayerEvent extends AbstractEventWithUserId {

    @NonNull
    private String playerId;

    @NonNull
    private String videoId;

    private String playbackDevice;

}
