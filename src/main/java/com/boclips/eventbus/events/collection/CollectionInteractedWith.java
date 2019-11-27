package com.boclips.eventbus.events.collection;

import com.boclips.eventbus.BoclipsEvent;
import com.boclips.eventbus.events.base.AbstractEventWithUserId;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@BoclipsEvent("collection-interacted-with")
public class CollectionInteractedWith extends AbstractEventWithUserId {

    @NonNull
    private String collectionId;

    @NonNull
    private String subtype;
}
