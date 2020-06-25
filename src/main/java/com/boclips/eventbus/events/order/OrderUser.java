package com.boclips.eventbus.events.order;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OrderUser {

    private String email;

    private String firstName;

    private String lastName;

    private String legacyUserId;

    private String label;

}
