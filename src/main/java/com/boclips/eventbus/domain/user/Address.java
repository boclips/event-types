package com.boclips.eventbus.domain.user;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Address {

    private String postcode;

    private String state;

    private String countryCode;
}
