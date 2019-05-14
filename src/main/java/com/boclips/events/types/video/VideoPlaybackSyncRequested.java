package com.boclips.events.types.video;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class VideoPlaybackSyncRequested {
    @NonNull
    private String videoId;
}
