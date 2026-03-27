package com.ctw.spring_catalog_products_api.controller;

import com.ctw.spring_catalog_products_api.dto.produto.ProdutoRequestDto;
import com.ctw.spring_catalog_products_api.dto.produto.ProdutoResponseDto;
import com.ctw.spring_catalog_products_api.service.ProdutoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produtos")
@RequiredArgsConstructor
public class ProdutoController {

    private final ProdutoService produtoService;

    @PostMapping
    public ProdutoResponseDto cadastrarProduto(
            @RequestBody ProdutoRequestDto produtoRequestDto,
            @RequestParam Long categoriaId
    ){
        return produtoService.cadastrarProduto(produtoRequestDto, categoriaId);
    }

    @GetMapping
    public List<ProdutoResponseDto> listarProdutos(){
        return produtoService.listarProdutos();
    }

    @GetMapping("/categoria/{nome}")
    public List<ProdutoResponseDto> listarProdutosPorCategoria(
            @RequestParam String nomeCategoria
    ){
        return produtoService.listarProdutosPorCategoria(nomeCategoria);
    }

    @GetMapping
    public List<ProdutoResponseDto> listarProdutosPorNome(
            @RequestParam String nome
    ){
        return produtoService.listarProdutosPorNome(nome);
    }

    @GetMapping
    public ProdutoResponseDto listarProdutoPorIdCategoriaNome(
            @RequestParam Long id,
            @RequestParam String nomeCategoria
    ){
        return produtoService.listarProdutoPorIdCategoriaNome(id,nomeCategoria);
    }
}
