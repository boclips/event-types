package com.boclips.events.types;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ContentPartnerExclusionFromSearchRequested {

    @NonNull
    private String contentPartnerId;
}
