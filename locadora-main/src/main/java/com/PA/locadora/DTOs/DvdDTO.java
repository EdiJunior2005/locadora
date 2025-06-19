package com.PA.locadora.DTOs;

import com.PA.locadora.models.Dvd;

public record DvdDTO(
    Long id,
    String title,
    String author,
    String duration,
    String classification,
    String categoryName
) {
    public DvdDTO(Dvd dvd) {
        this(
            dvd.getId(),
            dvd.getTitle(),
            dvd.getAuthor(),
            dvd.getDuration(),
            dvd.getClassification(),
            dvd.getCategory().getName()
        );
    }
}
