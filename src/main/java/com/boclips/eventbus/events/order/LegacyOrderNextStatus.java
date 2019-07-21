package com.boclips.eventbus.events.order;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LegacyOrderNextStatus {
    @NonNull
    private List<String> roles;

    @NonNull
    @JsonProperty("next_states")
    private List<String> nextStates;
}
