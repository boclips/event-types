package com.boclips.events.types.video;

import com.boclips.events.BoclipsEvent;
import lombok.*;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@BoclipsEvent("videos-inclusion-from-download-requested")
public class VideosInclusionInDownloadRequested {

    @NonNull
    private List<String> videoIds;
}
