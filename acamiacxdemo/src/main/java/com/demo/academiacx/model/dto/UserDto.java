package com.demo.academiacx.model.dto;

import com.demo.academiacx.model.UserModel;

public class UserDto {

    private Long id;

    private String nome;
    private String email;


    public UserDto() {
    }

    public UserDto(UserModel userModel) {
        this.id= userModel.getId();
        this.email = userModel.getEmail();
        this.nome = userModel.getName();
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
