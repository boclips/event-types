package com.boclips.eventbus.events.collection;

import com.boclips.eventbus.events.base.AbstractEventWithUserId;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class CollectionEvent extends AbstractEventWithUserId {

    @NonNull
    private String collectionId;
}
