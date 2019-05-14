package com.boclips.events.types.base;

import com.boclips.events.types.User;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class CollectionEvent extends Event implements UserEvent {

    @NonNull
    private User user;

    @NonNull
    private String collectionId;

}