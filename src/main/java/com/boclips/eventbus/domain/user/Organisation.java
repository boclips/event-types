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

    @NonNull
    private Address addres;

    @Deprecated
    private String postcode;

    @Deprecated
    private String state;

    @Deprecated
    private String countryCode;

    private Organisation parent;

    @NonNull
    private Deal deal;

    @NonNull
    private Set<String> tags;
}
