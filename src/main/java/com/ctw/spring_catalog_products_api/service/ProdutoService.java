package com.ctw.spring_catalog_products_api.service;

import com.ctw.spring_catalog_products_api.dto.produto.ProdutoRequestDto;
import com.ctw.spring_catalog_products_api.dto.produto.ProdutoResponseDto;
import com.ctw.spring_catalog_products_api.mapper.ProdutoMapper;
import com.ctw.spring_catalog_products_api.model.Categoria;
import com.ctw.spring_catalog_products_api.model.Produto;
import com.ctw.spring_catalog_products_api.repository.CategoriaRepository;
import com.ctw.spring_catalog_products_api.repository.ProdutoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProdutoService {

    private final ProdutoRepository produtoRepository;
    private final CategoriaRepository categoriaRepository;
    private final ProdutoMapper produtoMapper;

    public ProdutoResponseDto cadastrarProduto(
            ProdutoRequestDto produtoRequestDto,
            Long categoriaId
    ){
        Categoria categoria = categoriaRepository.findById(categoriaId)
                .orElseThrow(()-> new RuntimeException("Categoria não encontrada"));

        Produto produto = produtoMapper.toEntity(produtoRequestDto,categoria);

        produtoRepository.save(produto);

        return produtoMapper.toResponse(produto);
    }

    public List<ProdutoResponseDto> listarProdutos(){
        List<Produto> produtoList = produtoRepository.findAll();

        return produtoList.stream()
                .map(produtoMapper::toResponse)
                .toList();
    }

    public List<ProdutoResponseDto> listarProdutosPorCategoria(
            String nomeCategoria
    ){
        List<Produto> produtoList = produtoRepository.findProdutoByCategoriaNome(nomeCategoria);

        return produtoList.stream()
                .map(produtoMapper::toResponse)
                .toList();
    }

    public List<ProdutoResponseDto> listarProdutosPorNome(
            String nome
    ){
        List<Produto> produtoList = produtoRepository.findProdutoByNome(nome);

        return produtoList.stream()
                .map(produtoMapper::toResponse)
                .toList();
    }

    public ProdutoResponseDto listarProdutoPorIdCategoriaNome(
            Long id,
            String categoriaNome
    ){
        Produto produto = produtoRepository.findProdutoByIdAndCategoriaNome(id, categoriaNome)
                .orElseThrow(()-> new RuntimeException("Produto não encontrado por ID ou nome"));

        return produtoMapper.toResponse(produto);
    }

}
