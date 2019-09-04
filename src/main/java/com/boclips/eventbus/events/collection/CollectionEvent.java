package com.boclips.eventbus.events.collection;

import com.boclips.eventbus.events.base.UserEvent;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class CollectionEvent extends UserEvent {

    @NonNull
    private String collectionId;
}
