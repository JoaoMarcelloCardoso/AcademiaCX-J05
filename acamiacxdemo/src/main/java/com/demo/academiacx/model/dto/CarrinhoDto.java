package com.demo.academiacx.model.dto;

import com.demo.academiacx.model.CarrinhoModel;
import com.demo.academiacx.model.ClienteModel;

import java.math.BigDecimal;
import java.sql.Timestamp;

public class CarrinhoDto {

    private BigDecimal total;

    private Timestamp horaCompra;

    private ClienteModel cliente;

    public CarrinhoDto() {
    }

    public CarrinhoDto(CarrinhoModel carrinhoModel) {
        this.total = carrinhoModel.getTotal();
        this.horaCompra = carrinhoModel.getHoraCompra();
        this.cliente = carrinhoModel.getCliente_id();
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public Timestamp getHoraCompra() {
        return horaCompra;
    }

    public void setHoraCompra(Timestamp horaCompra) {
        this.horaCompra = horaCompra;
    }

    public ClienteModel getCliente() {
        return cliente;
    }

    public void setCliente(ClienteModel cliente) {
        this.cliente = cliente;
    }
}
