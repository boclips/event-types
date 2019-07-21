package com.boclips.eventbus.events.collection;

import com.boclips.eventbus.BoclipsEvent;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@BoclipsEvent("video-removed-from-collection")
public class VideoRemovedFromCollection extends CollectionEvent {

    @NonNull
    private String videoId;
}
