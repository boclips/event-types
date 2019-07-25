package com.boclips.eventbus.domain;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AgeRange {

    private Integer min;

    private Integer max;
}
