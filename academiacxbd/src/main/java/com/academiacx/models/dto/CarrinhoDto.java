package com.academiacx.models.dto;

import java.time.LocalDateTime;

public class CarrinhoDto {

    private LocalDateTime data_hora;
    private double total;
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public CarrinhoDto(LocalDateTime data_hora, double total) {
        this.data_hora = data_hora;
        this.total = total;
    }

    public CarrinhoDto() {
    }

    public LocalDateTime getData_hora() {
        return data_hora;
    }

    public void setData_hora(LocalDateTime data_hora) {
        this.data_hora = data_hora;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
}
