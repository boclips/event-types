package com.boclips.events.types.collection;

import com.boclips.events.types.base.CollectionEvent;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
public class CollectionVisibilityChanged extends CollectionEvent {

    @NonNull
    private Boolean isPublic;
}