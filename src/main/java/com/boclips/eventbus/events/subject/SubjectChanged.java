package com.boclips.eventbus.events.subject;

import com.boclips.eventbus.BoclipsEvent;
import com.boclips.eventbus.domain.Subject;
import com.boclips.eventbus.events.base.AbstractEvent;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@EqualsAndHashCode(callSuper=true)
@SuperBuilder
@BoclipsEvent("subject-updated")
public class SubjectChanged extends AbstractEvent {

    @NonNull
    private Subject subject;

}
