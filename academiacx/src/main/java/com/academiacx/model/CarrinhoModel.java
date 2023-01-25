package com.academiacx.model;

import com.academiacx.model.dto.CarrinhoDto;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.Date;


@Entity
@Table(name = "tb_carrinho")
public class CarrinhoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Date data;

    private BigDecimal total;

    @ManyToOne
    @JoinColumn(name = "cliente_id", nullable = false)
    private ClienteModel cliente;


    public CarrinhoModel() {

    }

    public CarrinhoModel(CarrinhoDto carrinhoDto) {
        this.id = carrinhoDto.getId();
        this.total = carrinhoDto.getTotal();
        this.data = carrinhoDto.getData();
        this.cliente = new ClienteModel(carrinhoDto.getCliente());
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public ClienteModel getCliente() {
        return cliente;
    }

    public void setCliente(ClienteModel cliente) {
        this.cliente = cliente;
    }
}
