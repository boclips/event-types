package com.boclips.eventbus.domain.contentpartner;

import com.boclips.eventbus.domain.AgeRange;
import lombok.*;

import java.util.List;
import java.util.Locale;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ContentPartner {
    @NonNull
    private ContentPartnerId id;

    @NonNull
    private String name;

    @NonNull
    private AgeRange ageRange;

    private String legalRestrictions;

    private String description;

    private List<String> contentTypes;

    private List<String> contentCategories;

    private Locale language;

    private String hubspotId;

    private String awards;

    private String notes;
}
