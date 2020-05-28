package com.boclips.eventbus.events.contentpartner;

import com.boclips.eventbus.BoclipsEvent;
import com.boclips.eventbus.domain.contentpartner.Channel;
import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@BoclipsEvent("channel-broadcast-requested")
public class BroadcastChannelRequested {
    @NonNull
    private Channel channel;
}