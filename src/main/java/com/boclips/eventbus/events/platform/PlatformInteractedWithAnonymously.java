package com.boclips.eventbus.events.platform;

import com.boclips.eventbus.BoclipsEvent;
import com.boclips.eventbus.events.base.AbstractEvent;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
@SuperBuilder
@ToString(callSuper = true)
@NoArgsConstructor
@BoclipsEvent("platform-interacted-with-anonymously")
public class PlatformInteractedWithAnonymously extends AbstractEvent {

    @NonNull
    private String subtype;
}
