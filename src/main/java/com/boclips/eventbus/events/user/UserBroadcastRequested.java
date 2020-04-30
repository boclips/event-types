package com.boclips.eventbus.events.user;

import com.boclips.eventbus.BoclipsEvent;
import com.boclips.eventbus.domain.user.User;
import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@BoclipsEvent("user-broadcast-requested")
public class UserBroadcastRequested {

    @NonNull
    private User user;
}
