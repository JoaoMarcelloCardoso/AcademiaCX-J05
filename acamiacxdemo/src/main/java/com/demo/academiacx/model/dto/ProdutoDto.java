package com.demo.academiacx.model.dto;

import com.demo.academiacx.model.ProdutoModel;

public class ProdutoDto {
    private Long id;

    private String nome;

    private Integer quantidadeTotal;

    public ProdutoDto() {
    }

    public ProdutoDto(ProdutoModel produtoModel) {
        this.id = produtoModel.getId();
        this.nome = produtoModel.getNome();
        this.quantidadeTotal = produtoModel.getQuantidadeTotal();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getQuantidadeTotal() {
        return quantidadeTotal;
    }

    public void setQuantidadeTotal(Integer quantidadeTotal) {
        this.quantidadeTotal = quantidadeTotal;
    }
}
