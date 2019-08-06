package com.boclips.eventbus.events.collection;

import com.boclips.eventbus.BoclipsEvent;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@BoclipsEvent("collection-description-changed")
public class CollectionDescriptionChanged extends CollectionEvent {
    @NonNull
    private String description;
}
