package com.boclips.eventbus.events.video;

import com.boclips.eventbus.events.base.UserEvent;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class VideoPlayerEvent extends UserEvent {

    @NonNull
    private String playerId;

    @NonNull
    private String videoId;

    @NonNull
    private Long videoDurationSeconds;

    private String consumerDevice;

}
