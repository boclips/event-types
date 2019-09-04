package com.boclips.eventbus.events.video;

import com.boclips.eventbus.BoclipsEvent;
import com.boclips.eventbus.events.base.AbstractUserEvent;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.List;

@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@BoclipsEvent("videos-searched")
public class VideosSearched extends AbstractUserEvent {

    @NonNull
    private String query;

    @NonNull
    private Integer pageIndex;

    @NonNull
    private Integer pageSize;

    @NonNull
    private Long totalResults;

    @NonNull
    private List<String> pageVideoIds;
}
