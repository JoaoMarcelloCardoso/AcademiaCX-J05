package com.spring.academiacx.model;

import com.spring.academiacx.model.dto.UserDto;
import jakarta.persistence.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

@Entity
@Table(name = "tb_user")
public class UserModel implements UserDetails {

    @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int cpf;
    private String nome;

    @Column(nullable = true, unique = true)
    private String username;
    @Column(nullable = true)
    private String password;


    public UserModel() {
    }

    public UserModel(UserDto userDto) {
        this.id= userDto.getId();
        this.nome= userDto.getNome();
        this.cpf=userDto.getCpf();

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getCpf() {
        return cpf;
    }

    public void setCpf(int cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getUsername() {
        return this.username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


}
