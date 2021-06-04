package com.boclips.eventbus.events.contentpartner;


import com.boclips.eventbus.BoclipsEvent;
import com.boclips.eventbus.domain.contentpartner.Channel;
import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@BoclipsEvent("channel-update-index")
public class ChannelUpdateIndex {
    @NonNull
    private Channel channel;
}
