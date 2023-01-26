package com.spring.academiacx.model;


import com.spring.academiacx.model.dto.CarrinhoDto;
import com.spring.academiacx.model.dto.EnderecoDto;
import jakarta.persistence.*;


import java.time.LocalDateTime;

@Entity
@Table(name = "tb_carrinho")
public class CarrinhoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDateTime datahora;
    private float total;
    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private UserModel userModel;

    public CarrinhoModel(CarrinhoDto carrinhoDto) {
        this.id= carrinhoDto.getId();
        this.datahora= carrinhoDto.getDatahora();
        this.total = carrinhoDto.getTotal();
        this.userModel = carrinhoDto.getUserModel();

    }

    public CarrinhoModel() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getDatahora() {
        return datahora;
    }

    public void setDatahora(LocalDateTime datahora) {
        this.datahora = datahora;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    public UserModel getUserModel() {
        return userModel;
    }

    public void setUserModel(UserModel userModel) {
        this.userModel = userModel;
    }
}
