package com.boclips.eventbus.domain.category;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.util.Set;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CategoryWithAncestors {
    private String code;
    private String description;
    @NonNull
    private Set<String> ancestors;
}
