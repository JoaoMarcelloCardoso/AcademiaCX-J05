package com.example.academiacx2.repository;

import com.example.academiacx2.model.EnderecoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface EnderecoRepository extends JpaRepository<EnderecoModel, Long> {

    Optional<EnderecoModel> findByCepAndUf(String cep, String uf);

    Optional<List<EnderecoModel>> findByCepOrUf(String cep, String uf);

    //QUERRY
    @Query("SELECT enderecoModel FROM EnderecoModel AS enderecoModel WHERE enderecoModel.id = ?1")
    Optional<EnderecoModel> buscaPorId(Long id);
}
