package com.boclips.eventbus.domain.page;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Viewport {
    @NonNull
    private Integer width;

    @NonNull
    private Integer height;
}