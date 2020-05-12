package com.boclips.eventbus.domain.contentpartner;

import com.boclips.eventbus.domain.AgeRange;
import com.boclips.eventbus.domain.Subject;
import com.boclips.eventbus.domain.Toggle;
import lombok.*;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ChannelPedagogyDetails {
    private List<Subject> subjects;

    private AgeRange ageRange;

    private List<String> bestForTags;

    private Toggle<String> curriculumAligned;

    private Toggle<String> educationalResources;

    private Boolean transcriptProvided;
}
