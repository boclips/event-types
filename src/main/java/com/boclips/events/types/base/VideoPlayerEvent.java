package com.boclips.events.types.base;

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

}
