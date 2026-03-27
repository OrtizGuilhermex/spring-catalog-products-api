package com.ctw.spring_catalog_products_api.dto.categoria;

import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;

public record CategoriaRequestDto (
        @Id
        @NotNull
        Long id,
        @NotNull
        String nomeCategoria
) {
}
