package com.boclips.eventbus.events.resource;


import com.boclips.eventbus.BoclipsEvent;
import com.boclips.eventbus.domain.ResourceType;
import com.boclips.eventbus.events.base.AbstractEventWithUserId;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.List;

@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@BoclipsEvent("resources-searched")
public class ResourcesSearched extends AbstractEventWithUserId {

    @NonNull
    private String query;

    @NonNull
    private ResourceType resourceType;

    @NonNull
    private Integer pageIndex;

    @NonNull
    private Integer pageSize;

    @NonNull
    private Long totalResults;

    @NonNull
    private List<String> pageResourceIds;
}
