package com.spring.academiacx.repository;

import com.spring.academiacx.model.PrecoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface PrecoRepository extends JpaRepository<PrecoModel, Long> {
    @Query("SELECT precoModel FROM PrecoModel AS precoModel WHERE precoModel.id = ?1")
    Optional<PrecoModel> buscaPorId(Long id);
}
