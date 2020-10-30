package com.boclips.eventbus.events.video;

import com.boclips.eventbus.BoclipsEvent;
import com.boclips.eventbus.events.base.AbstractSearchEventWithUserId;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.List;

@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@BoclipsEvent("videos-searched")
public class VideosSearched extends AbstractSearchEventWithUserId {

    @NonNull
    private List<String> pageVideoIds;
}
