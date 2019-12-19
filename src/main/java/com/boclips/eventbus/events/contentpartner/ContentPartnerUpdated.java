package com.boclips.eventbus.events.contentpartner;


import com.boclips.eventbus.BoclipsEvent;
import com.boclips.eventbus.domain.contentpartner.ContentPartner;
import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@BoclipsEvent("contentpartner-updated")
public class ContentPartnerUpdated {
    @NonNull
    private ContentPartner contentPartner;
}
