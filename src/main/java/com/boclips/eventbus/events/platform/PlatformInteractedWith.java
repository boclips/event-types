package com.boclips.eventbus.events.platform;

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
@BoclipsEvent("platform-interacted-with")
public class PlatformInteractedWith extends AbstractEventWithUserId {

  @NonNull
  private String subtype;
}
