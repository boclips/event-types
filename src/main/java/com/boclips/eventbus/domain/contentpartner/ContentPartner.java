package com.boclips.eventbus.domain.contentpartner;

import com.boclips.eventbus.domain.AgeRange;
import lombok.NonNull;

public class ContentPartner {
    @NonNull
    private ContentPartnerId id;

    @NonNull
    private String name;

    @NonNull
    private LegalRestrictions legalRestrictions;

    @NonNull
    private AgeRange ageRange;
}
