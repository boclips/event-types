package com.boclips.eventbus.events.video;

import com.boclips.eventbus.BoclipsEvent;
import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@BoclipsEvent("video-updated")
public class VideoUpdated {

    @NonNull
    private String videoId;

    @NonNull
    private String title;

    @NonNull
    private String contentPartnerName;
}
