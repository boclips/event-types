package com.boclips.events.types.collection;

import com.boclips.events.types.base.CollectionEvent;
import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class VideoAddedToCollection extends CollectionEvent {

    @NonNull
    private String videoId;
}
