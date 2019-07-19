package com.boclips.events.types.video;

import com.boclips.events.BoclipsEvent;
import com.boclips.events.config.legacy.TopicConstants;
import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@BoclipsEvent(TopicConstants.VIDEO_UPDATED)
public class VideoUpdated {

    @NonNull
    private String videoId;

    @NonNull
    private String title;

    @NonNull
    private String contentPartnerName;
}
