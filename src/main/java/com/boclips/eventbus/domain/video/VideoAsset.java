package com.boclips.eventbus.domain.video;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class VideoAsset {

    @NonNull
    private String id;

    @NonNull
    private Integer sizeKb;

    @NonNull
    private Dimensions dimensions;

    @NonNull
    private Integer bitrateKbps;

}
