package com.boclips.eventbus.events.collection;

import com.boclips.eventbus.BoclipsEvent;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.Set;

@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@BoclipsEvent("collection-subjects-changed")
public class CollectionSubjectsChanged extends CollectionEvent {

    @NonNull
    private Set<String> subjects;
}
