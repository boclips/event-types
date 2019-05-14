package com.boclips.events.types.video;

import com.boclips.events.types.User;
import com.boclips.events.types.base.Event;
import com.boclips.events.types.base.UserEvent;
import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class VideoSegmentPlayed extends Event implements UserEvent {
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
