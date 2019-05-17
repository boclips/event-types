package com.boclips.events.types.video;

import com.boclips.events.types.base.UserEvent;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class VideoSegmentPlayed extends UserEvent {

    @NonNull
    private String videoId;

    @NonNull
    private Integer videoIndex;

    @NonNull
    private String playerId;

    @NonNull
    private Long segmentStartSeconds;

    @NonNull
    private Long segmentEndSeconds;

    @NonNull
    private Long videoDurationSeconds;
}
