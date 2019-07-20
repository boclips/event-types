package com.boclips.events.types.video;

import com.boclips.events.BoclipsEvent;
import com.boclips.events.types.Subject;
import lombok.*;

import java.io.Serializable;
import java.util.Set;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@BoclipsEvent("video-subject-classified")
public class VideoSubjectClassified implements Serializable {

    @NonNull
    private String videoId;

    @NonNull
    private Set<Subject> subjects;
}
