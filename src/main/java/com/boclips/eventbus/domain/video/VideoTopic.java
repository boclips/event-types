package com.boclips.eventbus.domain.video;


import lombok.*;

import java.util.List;
import java.util.Locale;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class VideoTopic {
    @NonNull
    Double confidence;
    @NonNull
    private String name;
    @NonNull
    private Locale language;
    private VideoTopic parent;
}
