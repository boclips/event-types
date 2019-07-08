package com.boclips.events.types;

import lombok.*;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class VideosExclusionFromStreamRequested {

    @NonNull
    private List<String> videoIds;
}
