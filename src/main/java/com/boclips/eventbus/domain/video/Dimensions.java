package com.boclips.eventbus.domain.video;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Dimensions {

    @NonNull
    private Integer width;

    @NonNull
    private Integer height;
}
