package com.example.academiacx2.repository;

import com.example.academiacx2.model.PrecoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface PrecoRepository extends JpaRepository<PrecoModel, Long> {

    Optional<PrecoModel> findByValorAndId(Double valor, Long id);

    Optional<List<PrecoModel>> findByValorOrId(Double valor, Long id);

    //QUERRY
    @Query("SELECT precoModel FROM PrecoModel AS precoModel WHERE precoModel.id = ?1")
    Optional<PrecoModel> buscaPorId(Long id);
}
