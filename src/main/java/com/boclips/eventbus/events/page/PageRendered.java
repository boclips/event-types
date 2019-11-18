package com.boclips.eventbus.events.page;

import com.boclips.eventbus.BoclipsEvent;
import com.boclips.eventbus.events.base.AbstractEventWithUser;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
@SuperBuilder
@ToString(callSuper = true)
@NoArgsConstructor
@BoclipsEvent("page-rendered")
public class PageRendered extends AbstractEventWithUser {

}
