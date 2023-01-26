package com.spring.academiacx.model;


import com.spring.academiacx.model.dto.EnderecoDto;
import com.spring.academiacx.model.dto.ItemDto;
import jakarta.persistence.*;

@Entity
@Table(name = "tb_endereco")
public class EnderecoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int cep;
    private int numero;
    private String bairro;
    private String cidade;
    private String uf;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private UserModel userModel;

    public EnderecoModel(EnderecoDto enderecoDto) {
        this.id= enderecoDto.getId();
        this.cep= enderecoDto.getCep();
        this.numero = enderecoDto.getNumero();
        this.bairro = enderecoDto.getBairro();
        this.cidade = enderecoDto.getCidade();
        this.uf = enderecoDto.getUf();
        this.userModel = enderecoDto.getUserModel();
    }

    public EnderecoModel() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getCep() {
        return cep;
    }

    public void setCep(int cep) {
        this.cep = cep;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public UserModel getUserModel() {
        return userModel;
    }

    public void setUserModel(UserModel userModel) {
        this.userModel = userModel;
    }
}
