package com.boclips.events.types.video;

import com.boclips.events.BoclipsEvent;
import lombok.*;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@BoclipsEvent("videos-inclusion-from-stream-requested")
public class VideosInclusionInStreamRequested {

    @NonNull
    private List<String> videoIds;
}
