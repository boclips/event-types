package com.boclips.eventbus.events.contentpackage;

import com.boclips.eventbus.BoclipsEvent;
import com.boclips.eventbus.domain.contentpackage.ContentPackage;
import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@BoclipsEvent("content-package-broadcast-requested")
public class ContentPackageBroadcastRequested {
    @NonNull
    private ContentPackage contentPackage;
}
