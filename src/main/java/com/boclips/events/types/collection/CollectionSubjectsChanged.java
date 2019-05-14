package com.boclips.events.types.collection;

import com.boclips.events.types.base.CollectionEvent;
import com.boclips.events.types.base.Event;
import com.boclips.events.types.base.UserEvent;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.Set;

@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class CollectionSubjectsChanged extends CollectionEvent {

    @NonNull
    private Set<String> subjects;
}
