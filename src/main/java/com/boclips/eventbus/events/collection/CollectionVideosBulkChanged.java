package com.boclips.eventbus.events.collection;

import com.boclips.eventbus.BoclipsEvent;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.List;

@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@BoclipsEvent("collection-videos-bulk-changed")
public class CollectionVideosBulkChanged extends CollectionEvent {
    @NonNull
    private List<String> videoIds;
}
