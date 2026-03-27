package com.ctw.spring_catalog_products_api.mapper;

import com.ctw.spring_catalog_products_api.dto.categoria.CategoriaRequestDto;
import com.ctw.spring_catalog_products_api.dto.categoria.CategoriaResponseDto;
import com.ctw.spring_catalog_products_api.model.Categoria;
import org.springframework.stereotype.Component;

@Component
public class CategoriaMapper {

    public Categoria toEntity(
            CategoriaRequestDto categoriaRequestDto
    ){
        return new Categoria(
                categoriaRequestDto.id(),
                categoriaRequestDto.nomeCategoria()
        );
    }

    public CategoriaResponseDto toResponse(
            Categoria categoria
    ){
        return new CategoriaResponseDto(
                categoria.getNome()
        );
    }
}
