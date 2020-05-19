package com.boclips.eventbus.events.collection;

import com.boclips.eventbus.BoclipsEvent;
import com.boclips.eventbus.events.base.AbstractCollectionEvent;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@EqualsAndHashCode(callSuper=true)
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@ToString(callSuper = true)
@BoclipsEvent("collection-visibility-changed")
public class CollectionVisibilityChanged extends AbstractCollectionEvent {

    @Deprecated
    @NonNull
    private Boolean isPublic;

    private Boolean isDiscoverable;
}
