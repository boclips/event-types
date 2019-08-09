package com.boclips.eventbus.events.video;


import com.boclips.eventbus.BoclipsEvent;
import com.boclips.eventbus.events.base.UserEvent;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@BoclipsEvent("video-visited")
public class VideoVisited extends UserEvent {

    @NonNull
    private String videoId;

}
