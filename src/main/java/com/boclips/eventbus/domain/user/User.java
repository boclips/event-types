package com.boclips.eventbus.domain.user;

import com.boclips.eventbus.domain.Subject;
import lombok.*;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @NonNull
    private String id;

    private String firstName;

    private String lastName;

    private String email;

    @NonNull
    private List<Subject> subjects;

    @NonNull
    private List<Integer> ages;

    private Organisation organisation;

    @NonNull
    private Boolean isBoclipsEmployee;

    private String role;
}
