package com.boclips.events.types;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ContentPartnerInclusionInSearchRequested {

    @NonNull
    private String contentPartnerId;
}
