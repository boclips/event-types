package com.boclips.events.types.video;

import com.boclips.events.BoclipsEvent;
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
