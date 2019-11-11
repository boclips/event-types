package com.boclips.eventbus.domain.collection;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CollectionId {
    private String value;

    public static CollectionId of(String value) {
        return new CollectionId(value);
    }
}
