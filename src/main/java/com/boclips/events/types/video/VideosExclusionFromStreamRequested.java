package com.boclips.events.types.video;

import com.boclips.events.BoclipsEvent;
import lombok.*;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@BoclipsEvent("videos-exclusion-from-stream-requested")
public class VideosExclusionFromStreamRequested {

    @NonNull
    private List<String> videoIds;
}
