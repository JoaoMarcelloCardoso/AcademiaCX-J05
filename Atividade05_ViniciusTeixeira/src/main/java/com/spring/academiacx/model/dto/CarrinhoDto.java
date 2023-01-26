package com.spring.academiacx.model.dto;

import com.spring.academiacx.model.CarrinhoModel;
import com.spring.academiacx.model.UserModel;

import java.time.LocalDateTime;

public class CarrinhoDto {

    private Long id;
    private LocalDateTime datahora;
    private float total;
    private UserModel userModel;

    public CarrinhoDto() {
    }

    public CarrinhoDto(CarrinhoModel carrinhoModel) {
        this.id= carrinhoModel.getId();
        this.datahora = carrinhoModel.getDatahora();
        this.total = carrinhoModel.getTotal();
        this.userModel = carrinhoModel.getUserModel();

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
