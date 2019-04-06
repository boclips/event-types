package com.boclips.events.types;

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
