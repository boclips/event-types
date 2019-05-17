package com.boclips.events.types.collection;

import com.boclips.events.types.base.CollectionEvent;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.List;

@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class CollectionVideosChanged extends CollectionEvent {

    @NonNull
    private List<String> addedVideos;

    @NonNull
    private List<String> removedVideos;
}
