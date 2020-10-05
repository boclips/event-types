package com.boclips.eventbus.domain.contentpackage;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ContentPackage {
    @NonNull
    ContentPackageId id;
    @NonNull
    String name;
}
