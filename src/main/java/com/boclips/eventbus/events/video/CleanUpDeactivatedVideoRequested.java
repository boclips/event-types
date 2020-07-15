package com.boclips.eventbus.events.video;

import com.boclips.eventbus.BoclipsEvent;
import lombok.*;

import java.util.Locale;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@BoclipsEvent("clean-up-deactivated-video-requested")
public class CleanUpDeactivatedVideoRequested {

    @NonNull
    private String videoId;

}
