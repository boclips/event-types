package com.boclips.eventbus.events.collection;

import com.boclips.eventbus.BoclipsEvent;
import com.boclips.eventbus.events.base.CollectionEvent;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@BoclipsEvent("collection-age-range-changed")
public class CollectionAgeRangeChanged extends CollectionEvent {

    @NonNull
    private Integer rangeMin;

    private Integer rangeMax;
}
