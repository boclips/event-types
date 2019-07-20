package com.boclips.events.types.collection;

import com.boclips.events.BoclipsEvent;
import com.boclips.events.types.base.CollectionEvent;
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
