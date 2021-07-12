package com.boclips.eventbus.events.video;

import com.boclips.eventbus.BoclipsEvent;
import lombok.*;

import java.io.Serializable;
import java.util.Set;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@BoclipsEvent("video-taxonomy-classified")
public class VideoTaxonomyClassified implements Serializable {
    @NonNull
    private String id;

    @NonNull
    private Set<String> taxonomy;
}
