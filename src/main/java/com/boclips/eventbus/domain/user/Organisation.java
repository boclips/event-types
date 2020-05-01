package com.boclips.eventbus.domain.user;

import lombok.*;

import java.util.Set;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Organisation {

    @NonNull
    private String id;

    @NonNull
    private String type;

    @NonNull
    private String name;

    private String postcode;

    private String state;

    private String countryCode;

    private Organisation parent;

    @NonNull
    @Deprecated
    private String accountType;

    @NonNull
    private Set<String> tags;
}
