package com.boclips.eventbus.domain.category;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CategoryWithAncestors {
    private String code;
    private String description;
    private Set<String> ancestors;
}
