package com.boclips.events.types.video;

import com.boclips.events.BoclipsEvent;
import com.boclips.events.types.base.UserEvent;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.List;

@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@BoclipsEvent("videos-searched")
public class VideosSearched extends UserEvent {

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
