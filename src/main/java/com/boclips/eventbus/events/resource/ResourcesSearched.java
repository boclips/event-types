package com.boclips.eventbus.events.resource;


import com.boclips.eventbus.BoclipsEvent;
import com.boclips.eventbus.domain.ResourceType;
import com.boclips.eventbus.events.base.AbstractSearchEventWithUserId;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.List;

@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@BoclipsEvent("resources-searched")
public class ResourcesSearched extends AbstractSearchEventWithUserId {

    @NonNull
    private ResourceType resourceType;

    @NonNull
    private List<String> pageResourceIds;
}
