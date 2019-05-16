package com.boclips.events.types.video;

import com.boclips.events.types.User;
import com.boclips.events.types.base.Event;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class VideoSegmentPlayed extends Event {
    @NonNull
    private User user;

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
