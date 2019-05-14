package com.boclips.events.types.video;

import com.boclips.events.types.User;
import com.boclips.events.types.base.Event;
import com.boclips.events.types.base.UserEvent;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class VideosSearched extends Event implements UserEvent {

    @NonNull
    private User user;

    @NonNull
    private String query;

    @NonNull
    private Integer pageIndex;

    @NonNull
    private Integer pageSize;

    @NonNull
    private Integer totalResults;
}
