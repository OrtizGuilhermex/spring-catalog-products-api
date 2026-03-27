package com.ctw.spring_catalog_products_api.service;

import com.ctw.spring_catalog_products_api.dto.categoria.CategoriaRequestDto;
import com.ctw.spring_catalog_products_api.dto.categoria.CategoriaResponseDto;
import com.ctw.spring_catalog_products_api.mapper.CategoriaMapper;
import com.ctw.spring_catalog_products_api.model.Categoria;
import com.ctw.spring_catalog_products_api.repository.CategoriaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CategoriaService {

    private final CategoriaRepository categoriaRepository;
    private final CategoriaMapper categoriaMapper;

    public CategoriaResponseDto cadastrarCategoria(
            CategoriaRequestDto categoriaRequestDto
    ){
        Categoria categoria = categoriaMapper.toEntity(categoriaRequestDto);

        categoriaRepository.save(categoria);

        return categoriaMapper.toResponse(categoria);
    }

    public CategoriaResponseDto buscarCategoriaPorId(
            Long id
    ){
      Categoria categoria = categoriaRepository.findById(id)
              .orElseThrow(()-> new RuntimeException("Categoria não encontrada!"));

      return categoriaMapper.toResponse(categoria);
    }
}
