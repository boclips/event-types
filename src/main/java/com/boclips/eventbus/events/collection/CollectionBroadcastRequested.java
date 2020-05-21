package com.boclips.eventbus.events.collection;

import com.boclips.eventbus.BoclipsEvent;
import com.boclips.eventbus.domain.collection.Collection;
import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@BoclipsEvent("collection-broadcast-requested")
public class CollectionBroadcastRequested {

    @NonNull
    private Collection collection;
}
