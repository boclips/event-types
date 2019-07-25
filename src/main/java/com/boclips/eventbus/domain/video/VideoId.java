package com.boclips.eventbus.domain.video;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class VideoId {
    private String value;

    public static VideoId of(String value) {
        return new VideoId(value);
    }
}
