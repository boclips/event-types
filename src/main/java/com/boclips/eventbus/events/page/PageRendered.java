package com.boclips.eventbus.events.page;

import com.boclips.eventbus.BoclipsEvent;
import com.boclips.eventbus.domain.page.Viewport;
import com.boclips.eventbus.events.base.AbstractEventWithUserId;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
@SuperBuilder
@ToString(callSuper = true)
@NoArgsConstructor
@BoclipsEvent("page-rendered")
public class PageRendered extends AbstractEventWithUserId {

    private Viewport viewport;
}
