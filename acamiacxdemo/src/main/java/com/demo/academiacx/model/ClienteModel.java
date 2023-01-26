package com.demo.academiacx.model;

import com.demo.academiacx.model.dto.ClienteDto;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "tb_cliente")
public class ClienteModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    private String cpf;

    private String nome;

    public ClienteModel(ClienteDto clienteDto) {
        this.id = null;
        this.cpf = clienteDto.getCpf();
        this.nome = clienteDto.getNome();
        this.enderecos = clienteDto.getEnderecos();
        this.precos = clienteDto.getPrecos();
        this.carrinhos = clienteDto.getCarrinhos();
    }

    @OneToMany(mappedBy = "cliente")
    private List<EnderecoModel> enderecos;

    @OneToMany(mappedBy = "cliente")
    private List<PrecoModel> precos;

    @OneToMany(mappedBy = "cliente")
    private List<CarrinhoModel> carrinhos;

    public ClienteModel() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<EnderecoModel> getEnderecos() {
        return enderecos;
    }

    public void setEnderecos(List<EnderecoModel> enderecos) {
        this.enderecos = enderecos;
    }

    public List<PrecoModel> getPrecos() {
        return precos;
    }

    public void setPrecos(List<PrecoModel> precos) {
        this.precos = precos;
    }

    public List<CarrinhoModel> getCarrinhos() {
        return carrinhos;
    }

    public void setCarrinhos(List<CarrinhoModel> carrinhos) {
        this.carrinhos = carrinhos;
    }
}
