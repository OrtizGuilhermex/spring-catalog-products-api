package com.ctw.spring_catalog_products_api.dto.produto;

import jakarta.validation.constraints.NotNull;

public record ProdutoResponseDto (
        @NotNull
        String nome,
        @NotNull
        double preco,
        @NotNull
        String nomeCategoria
) {
}
