package com.boclips.eventbus.events.video;

import com.boclips.eventbus.BoclipsEvent;
import com.boclips.eventbus.domain.video.Video;
import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@BoclipsEvent("video-event-structure-changed")
public class VideoEventStructureChanged {

    @NonNull
    private Video video;

    public static VideoEventStructureChanged of(Video video) {
        return new VideoEventStructureChanged(video);
    }
}
