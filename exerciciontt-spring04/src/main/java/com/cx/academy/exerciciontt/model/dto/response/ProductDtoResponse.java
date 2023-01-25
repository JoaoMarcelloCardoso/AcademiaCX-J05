package com.cx.academy.exerciciontt.model.dto.response;

public class ProductDtoResponse {
    private Long id;

    private String nome;

    private Double price;

    public ProductDtoResponse(Long id, String nome, Double price) {
        this.id = id;
        this.nome = nome;
        this.price = price;
    }

    public ProductDtoResponse() {
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

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
