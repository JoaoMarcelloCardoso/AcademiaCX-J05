package com.spring.academiacx.model.dto;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.spring.academiacx.model.UserModel;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class UserDto {

    private Long id;
    private String nome;

    private int cpf;

    private String username;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;

    public UserDto() {
    }

    public UserDto(UserModel userModel) {
        this.id= userModel.getId();
        this.nome=userModel.getNome();
        this.cpf=userModel.getCpf();
        this.username=userModel.getUsername();
        this.password=userModel.getPassword();

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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return new BCryptPasswordEncoder().encode(password);
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getCpf() {
        return cpf;
    }

    public void setCpf(int cpf) {
        this.cpf = cpf;
    }
}