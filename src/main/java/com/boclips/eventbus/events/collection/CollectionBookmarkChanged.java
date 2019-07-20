package com.boclips.eventbus.events.collection;

import com.boclips.eventbus.BoclipsEvent;
import com.boclips.eventbus.events.base.CollectionEvent;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@BoclipsEvent("collection-bookmark-changed")
public class CollectionBookmarkChanged extends CollectionEvent {

    @NonNull
    private Boolean isBookmarked;
}
