package com.boclips.eventbus.events.base;

import lombok.*;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@SuperBuilder
@EqualsAndHashCode(callSuper=true)
@NoArgsConstructor
@AllArgsConstructor
public abstract class AbstractCollectionEvent extends AbstractEventWithUserId {

    @NonNull
    private String collectionId;
}
