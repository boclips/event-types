package com.boclips.eventbus.events.collection;

import com.boclips.eventbus.events.base.AbstractUserEvent;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class CollectionEvent extends AbstractUserEvent {

    @NonNull
    private String collectionId;
}
