package com.boclips.eventbus.domain.user;

import com.boclips.eventbus.domain.Subject;
import lombok.*;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserProfile {
    private String firstName;

    private String lastName;

    @NonNull
    private List<Subject> subjects;

    @NonNull
    private List<Integer> ages;

    private Organisation school;

    private String role;

    @NonNull
    private Boolean hasOptedIntoMarketing;
}
