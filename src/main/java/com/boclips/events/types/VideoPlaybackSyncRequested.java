package com.boclips.events.types;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class VideoPlaybackSyncRequested {
    @NonNull
    private String videoId;
}
