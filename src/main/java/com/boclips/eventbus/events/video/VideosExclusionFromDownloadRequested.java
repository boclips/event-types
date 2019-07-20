package com.boclips.eventbus.events.video;

import com.boclips.eventbus.BoclipsEvent;
import lombok.*;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@BoclipsEvent("videos-exclusion-from-download-requested")
public class VideosExclusionFromDownloadRequested {

    @NonNull
    private List<String> videoIds;
}
