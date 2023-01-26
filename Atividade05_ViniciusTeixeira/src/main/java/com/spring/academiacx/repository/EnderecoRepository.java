package com.spring.academiacx.repository;

import com.spring.academiacx.model.EnderecoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface EnderecoRepository extends JpaRepository<EnderecoModel, Long> {
    @Query("SELECT enderecoModel FROM EnderecoModel AS enderecoModel WHERE enderecoModel.id = ?1")
    Optional<EnderecoModel> buscaPorId(Long id);
}
