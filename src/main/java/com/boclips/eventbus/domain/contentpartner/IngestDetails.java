package com.boclips.eventbus.domain.contentpartner;

import lombok.*;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class IngestDetails {

    @NonNull
    private String type;

    private List<String> urls;
}
