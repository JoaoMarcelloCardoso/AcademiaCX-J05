package com.academiacx.models.dto;

public class PrecoDto {

    private double valor;
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public PrecoDto() {
    }

    public PrecoDto(double valor) {
        this.valor = valor;


    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }
}
