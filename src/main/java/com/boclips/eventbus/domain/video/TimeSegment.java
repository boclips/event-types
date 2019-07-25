package com.boclips.eventbus.domain.video;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TimeSegment {

    @NonNull
    private Integer startSecond;

    @NonNull
    private Integer endSecond;
}
