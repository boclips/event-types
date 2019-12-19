package com.boclips.eventbus.domain.contentpartner;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LegalRestrictions {
    @NonNull
    private LegalRestrictionsId id;

    @NonNull
    private String text;
}
