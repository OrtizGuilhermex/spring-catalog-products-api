package com.ctw.spring_catalog_products_api.controller;

import com.ctw.spring_catalog_products_api.dto.produto.ProdutoRequestDto;
import com.ctw.spring_catalog_products_api.dto.produto.ProdutoResponseDto;
import com.ctw.spring_catalog_products_api.service.ProdutoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produtos")
@RequiredArgsConstructor
public class ProdutoController {

    private final ProdutoService produtoService;

    @PostMapping
    public ResponseEntity<ProdutoResponseDto> cadastrarProduto(
            @RequestBody ProdutoRequestDto produtoRequestDto,
            @RequestParam Long categoriaId
    ){
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(produtoService.cadastrarProduto(produtoRequestDto, categoriaId));
    }

    @GetMapping
    public ResponseEntity<List<ProdutoResponseDto>> listarProdutos(){
        return ResponseEntity.status(HttpStatus.OK)
                .body(produtoService.listarProdutos());

    }

    @GetMapping("/categoria/{nome}")
    public ResponseEntity<List<ProdutoResponseDto>> listarProdutosPorCategoria(
            @RequestParam String nomeCategoria
    ){
        return ResponseEntity.status(HttpStatus.OK)
                .body(produtoService.listarProdutosPorCategoria(nomeCategoria));
    }

    @GetMapping
    public ResponseEntity<List<ProdutoResponseDto>> listarProdutosPorNome(
            @RequestParam String nome
    ){
        return ResponseEntity.status(HttpStatus.OK)
                .body(produtoService.listarProdutosPorNome(nome));
    }

    @GetMapping()
    public ResponseEntity<ProdutoResponseDto> listarProdutoPorIdCategoriaNome(
            @RequestParam Long id,
            @RequestParam String nomeCategoria
    ){
        return ResponseEntity.status(HttpStatus.OK)
                .body(produtoService.listarProdutoPorIdCategoriaNome(id,nomeCategoria));
    }
}
