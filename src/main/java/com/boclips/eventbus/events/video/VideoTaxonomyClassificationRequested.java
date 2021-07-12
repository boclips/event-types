package com.boclips.eventbus.events.video;


import com.boclips.eventbus.BoclipsEvent;
import lombok.*;

import java.io.Serializable;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@BoclipsEvent("video-taxonomy-classification-requested")
public class VideoTaxonomyClassificationRequested implements Serializable {
    @NonNull
    private String videoId;

    @NonNull
    private String title;

    @NonNull
    private String description;

    @NonNull
    private String transcript;
}
