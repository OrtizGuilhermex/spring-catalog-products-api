package com.ctw.spring_catalog_products_api.controller;

import com.ctw.spring_catalog_products_api.dto.categoria.CategoriaRequestDto;
import com.ctw.spring_catalog_products_api.dto.categoria.CategoriaResponseDto;
import com.ctw.spring_catalog_products_api.service.CategoriaService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/categorias")
@RequiredArgsConstructor
public class CategoriaController {

    private final CategoriaService categoriaService;

    @PostMapping
    public CategoriaResponseDto cadastrarCategoria(
            @RequestBody CategoriaRequestDto categoriaRequestDto
    ){
        return categoriaService.cadastrarCategoria(categoriaRequestDto);
    }

    @GetMapping("/{id}")
    public CategoriaResponseDto buscarCategoriaPorId(
            @PathVariable Long id
    ){
        return categoriaService.buscarCategoriaPorId(id);
    }
}
