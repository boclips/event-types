package com.boclips.events.types.collection;

import com.boclips.events.types.base.CollectionEvent;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class CollectionAgeRangeChanged extends CollectionEvent {

    @NonNull
    private Integer rangeMin;

    private Integer rangeMax;
}
