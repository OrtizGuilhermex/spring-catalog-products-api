package com.ctw.spring_catalog_products_api.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "produto")
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @Column
    private double preco;

    @ManyToOne
    @JoinColumn(name = "categoria")
    private Categoria categoria;

    public Produto (String nome, double preco){
        this.nome = nome;
        this.preco = preco;
    }
}
