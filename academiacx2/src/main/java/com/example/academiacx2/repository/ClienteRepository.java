package com.example.academiacx2.repository;

import com.example.academiacx2.model.ClienteModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

public interface ClienteRepository extends JpaRepository<ClienteModel, Long> {

    Optional<ClienteModel> findByCpfAndNome(String cpf, String nome);

    Optional<ClienteModel> findByUsername(String username);

    Optional<List<ClienteModel>> findByCpfOrNome(String cpf, String nome);

    //QUERRY

    @Query("SELECT clienteModel FROM ClienteModel AS clienteModel WHERE clienteModel.id = ?1")
    Optional<ClienteModel> buscaPorId(Long id);
}
