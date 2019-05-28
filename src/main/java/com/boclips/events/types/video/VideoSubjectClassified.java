package com.boclips.events.types.video;

import com.boclips.events.types.Subject;
import lombok.*;

import java.util.Set;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class VideoSubjectClassified {

    @NonNull
    private String videoId;

    @NonNull
    private Set<Subject> subjects;
}
