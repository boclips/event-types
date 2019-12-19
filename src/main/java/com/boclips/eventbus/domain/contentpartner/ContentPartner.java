package com.boclips.eventbus.domain.contentpartner;

import com.boclips.eventbus.domain.AgeRange;
import lombok.*;

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

    private LegalRestrictions legalRestrictions;
}
