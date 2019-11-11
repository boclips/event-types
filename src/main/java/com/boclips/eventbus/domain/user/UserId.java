package com.boclips.eventbus.domain.user;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserId {
    private String value;

    public static UserId of(String value) {
        return new UserId(value);
    }
}
