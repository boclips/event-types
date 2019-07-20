package com.boclips.events.types.video;

import com.boclips.events.BoclipsEvent;
import com.boclips.events.types.base.VideoPlayerEvent;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@BoclipsEvent("video-segment-played")
public class VideoSegmentPlayed extends VideoPlayerEvent {

    private Integer videoIndex;

    @NonNull
    private Long segmentStartSeconds;

    @NonNull
    private Long segmentEndSeconds;

}
