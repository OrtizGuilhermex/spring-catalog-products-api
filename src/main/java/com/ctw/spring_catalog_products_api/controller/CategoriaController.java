package com.ctw.spring_catalog_products_api.controller;

import com.ctw.spring_catalog_products_api.dto.categoria.CategoriaRequestDto;
import com.ctw.spring_catalog_products_api.dto.categoria.CategoriaResponseDto;
import com.ctw.spring_catalog_products_api.service.CategoriaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/categorias")
@RequiredArgsConstructor
public class CategoriaController {

    private final CategoriaService categoriaService;

    @PostMapping
    public ResponseEntity<CategoriaResponseDto> cadastrarCategoria(
            @RequestBody CategoriaRequestDto categoriaRequestDto
    ){
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(categoriaService.cadastrarCategoria(categoriaRequestDto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<CategoriaResponseDto> buscarCategoriaPorId(
            @PathVariable Long id
    ){
        return ResponseEntity.status(HttpStatus.OK)
                .body(categoriaService.buscarCategoriaPorId(id));
    }
}
