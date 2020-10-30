package com.boclips.eventbus.events.base;

import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.List;
import java.util.Map;

@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class AbstractSearchEventWithUserId extends AbstractEventWithUserId {

    @NonNull
    private String query;

    private Map<String, List<String>> queryParams;

    @NonNull
    private Integer pageIndex;

    @NonNull
    private Integer pageSize;

    @NonNull
    private Long totalResults;
}
