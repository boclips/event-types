package com.boclips.eventbus.events.contentpartner;

import com.boclips.eventbus.BoclipsEvent;
import lombok.*;
import java.util.Locale;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@BoclipsEvent("channel-analysis-requested")
public class ChannelAnalysisRequested {
    @NonNull
    private String channelId;

    private Boolean isVoiced;

    private Locale language;
}

