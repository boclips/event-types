package com.boclips.events.types.collection;

import com.boclips.events.types.base.CollectionEvent;
import com.boclips.events.types.base.Event;
import com.boclips.events.types.base.UserEvent;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class VideoRemovedFromCollection extends CollectionEvent {

    @NonNull
    private String videoId;
}
