package com.boclips.eventbus.domain.contentpartner;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class IngestDetails {

    @NonNull
    private String type;

    private String url;
}
