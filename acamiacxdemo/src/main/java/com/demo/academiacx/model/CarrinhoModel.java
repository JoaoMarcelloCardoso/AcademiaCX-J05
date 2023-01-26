package com.demo.academiacx.model;

import com.demo.academiacx.model.dto.CarrinhoDto;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.sql.Timestamp;

@Entity
@Table(name = "tb_carrinho")
public class CarrinhoModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    private BigDecimal total;

    private Timestamp horaCompra;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private ClienteModel cliente;



    public CarrinhoModel(CarrinhoDto carrinhoDto) {
        this.id = null;
        this.total = carrinhoDto.getTotal();
        this.horaCompra = carrinhoDto.getHoraCompra();
        this.cliente = carrinhoDto.getCliente();
    }

    public CarrinhoModel() {

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

    public ClienteModel getCliente_id() {
        return cliente;
    }

    public void setCliente_id(ClienteModel cliente) {
        this.cliente = cliente;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
