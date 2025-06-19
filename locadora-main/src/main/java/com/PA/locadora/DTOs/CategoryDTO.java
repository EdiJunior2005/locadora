package com.PA.locadora.DTOs;

import com.PA.locadora.models.Category;

public record CategoryDTO(
        Long id,
        String name,
        String description
) {
    public CategoryDTO(Category category) {
        this(
            category.getId(),
            category.getName(),
            category.getDescription()
        );
    }
}
