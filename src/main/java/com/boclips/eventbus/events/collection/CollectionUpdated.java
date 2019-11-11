package com.boclips.eventbus.events.collection;

import com.boclips.eventbus.BoclipsEvent;
import com.boclips.eventbus.domain.collection.Collection;
import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@BoclipsEvent("collection-updated")
public class CollectionUpdated {

    @NonNull
    private Collection collection;
}
