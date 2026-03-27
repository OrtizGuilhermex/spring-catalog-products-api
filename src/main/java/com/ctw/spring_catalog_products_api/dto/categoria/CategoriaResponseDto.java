package com.ctw.spring_catalog_products_api.dto.categoria;

import jakarta.validation.constraints.NotNull;

public record CategoriaResponseDto (
        @NotNull
        String nomeCategoria
) {
}
