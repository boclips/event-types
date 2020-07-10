package com.boclips.eventbus.events.searchsuggestions;

import com.boclips.eventbus.BoclipsEvent;
import com.boclips.eventbus.events.base.AbstractEventWithUser;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.List;

@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
@SuperBuilder
@ToString(callSuper = true)
@NoArgsConstructor
@BoclipsEvent("search-query-completions-suggested")
public class SearchQueryCompletionsSuggested extends AbstractEventWithUser {

    @NonNull
    private List<String> impressions;

    @NonNull
    private String completionId;

    @NonNull
    private String searchQuery;

    @NonNull
    private String componentId;
}
