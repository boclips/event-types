package com.boclips.events.types.collection;

import com.boclips.events.types.base.CollectionEvent;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
public class CollectionMadePrivate extends CollectionEvent {
}