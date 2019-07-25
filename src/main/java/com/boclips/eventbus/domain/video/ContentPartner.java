package com.boclips.eventbus.domain.video;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ContentPartner {
    private String name;

    public static ContentPartner of(String name) {
        return new ContentPartner(name);
    }
}
