package com.boclips.eventbus.events.video;

import com.boclips.eventbus.BoclipsEvent;
import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@BoclipsEvent("video-playback-sync-requested")
public class VideoPlaybackSyncRequested {
    @NonNull
    private String videoId;
}
