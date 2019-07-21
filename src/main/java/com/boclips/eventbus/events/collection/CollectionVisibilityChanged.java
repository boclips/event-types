package com.boclips.eventbus.events.collection;

import com.boclips.eventbus.BoclipsEvent;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@BoclipsEvent("collection-visibility-changed")
public class CollectionVisibilityChanged extends CollectionEvent {

    @NonNull
    private Boolean isPublic;
}
