package com.ctw.spring_catalog_products_api.repository;

import com.ctw.spring_catalog_products_api.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto,Long> {

    List<Produto> findProdutoByCategoriaNome(String nomeCategoria);
    List<Produto> findProdutoByNome(String nome);
    Optional<Produto> findProdutoByIdAndCategoriaNome(Long id, String nomeCategoria);

}
