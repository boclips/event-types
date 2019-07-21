package com.boclips.eventbus.events.collection;

import com.boclips.eventbus.BoclipsEvent;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@BoclipsEvent("collection-renamed")
public class CollectionRenamed extends CollectionEvent {

    @NonNull
    private String collectionTitle;
}
