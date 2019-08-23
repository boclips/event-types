package com.boclips.eventbus.events.video;

import com.boclips.eventbus.BoclipsEvent;
import com.boclips.eventbus.domain.video.Video;
import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@BoclipsEvent("video-updated")
public class VideoUpdated {

    @NonNull
    private Video video;

    public static VideoUpdated of(Video video) {
        return new VideoUpdated(video);
    }
}
