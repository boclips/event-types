package com.boclips.eventbus.events.searchsuggestions;

import com.boclips.eventbus.BoclipsEvent;
import com.boclips.eventbus.events.base.AbstractEventWithUserId;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
@SuperBuilder
@ToString(callSuper = true)
@NoArgsConstructor
@BoclipsEvent("search-query-completions-suggested")
public class SearchQueryCompletionsSuggested extends AbstractEventWithUserId {

    @NonNull
    private String[] impressions;

    @NonNull
    private String completionId;

    @NonNull
    private String searchQuery;

    @NonNull
    private String componentId;
}
