package com.cx.academy.exerciciontt.repository;

import com.cx.academy.exerciciontt.model.ClientModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ClientRepository extends JpaRepository<ClientModel, Long> {

    Optional<ClientModel> findByUsername(String username);

    Optional<ClientModel> findByNome(String nome);


}
