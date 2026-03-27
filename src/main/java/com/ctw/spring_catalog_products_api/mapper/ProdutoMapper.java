package com.ctw.spring_catalog_products_api.mapper;

import com.ctw.spring_catalog_products_api.dto.produto.ProdutoRequestDto;
import com.ctw.spring_catalog_products_api.dto.produto.ProdutoResponseDto;
import com.ctw.spring_catalog_products_api.model.Categoria;
import com.ctw.spring_catalog_products_api.model.Produto;
import org.springframework.stereotype.Component;

@Component
public class ProdutoMapper {

    public Produto toEntity(
            ProdutoRequestDto produtoRequestDto,
            Categoria categoria
    ){
        return new Produto(
                produtoRequestDto.id(),
                produtoRequestDto.nome(),
                produtoRequestDto.preco(),
                categoria
        );
    }

    public ProdutoResponseDto toResponse(
            Produto produto
    ){
        return new ProdutoResponseDto(
                produto.getNome(),
                produto.getPreco(),
                produto.getCategoria().getNome()
        );
    }

}
