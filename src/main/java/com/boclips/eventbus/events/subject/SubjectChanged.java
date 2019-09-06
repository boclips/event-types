package com.boclips.eventbus.events.subject;

import com.boclips.eventbus.BoclipsEvent;
import com.boclips.eventbus.domain.Subject;
import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@BoclipsEvent("subject-updated")
public class SubjectChanged {

    @NonNull
    private Subject subject;

}
