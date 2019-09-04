package com.boclips.eventbus.events.video;

import com.boclips.eventbus.BoclipsEvent;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@BoclipsEvent("video-segment-played")
public class VideoSegmentPlayed extends AbstractVideoEvent {

    private Integer videoIndex;

    @NonNull
    private Long segmentStartSeconds;

    @NonNull
    private Long segmentEndSeconds;

}
