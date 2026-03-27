package com.ctw.spring_catalog_products_api.dto.produto;

import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;

public record ProdutoRequestDto (
        @Id
        @NotNull
        Long id,
        @NotNull
        String nome,
        @NotNull
        double preco,
        @NotNull
        String nomeCategoria
) {
}
