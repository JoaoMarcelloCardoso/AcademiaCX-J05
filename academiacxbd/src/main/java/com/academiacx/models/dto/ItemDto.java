package com.academiacx.models.dto;

public class ItemDto {

    private int quantidade;
    private double total;

    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ItemDto(int quantidade, double total) {
        this.quantidade = quantidade;
        this.total = total;
    }

    public ItemDto() {
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
}
