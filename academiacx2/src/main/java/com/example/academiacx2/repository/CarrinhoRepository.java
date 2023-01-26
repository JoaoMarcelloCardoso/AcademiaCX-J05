package com.example.academiacx2.repository;

import com.example.academiacx2.model.CarrinhoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface CarrinhoRepository extends JpaRepository<CarrinhoModel, Long>  {

    Optional<CarrinhoModel> findByDatahoraAndTotal(LocalDateTime datahora, Double total);

    Optional<List<CarrinhoModel>> findByDatahoraOrTotal(LocalDateTime datahora, Double total);

    //QUERRY
    @Query("SELECT carrinhoModel FROM CarrinhoModel AS carrinhoModel WHERE carrinhoModel.id = ?1")
    Optional<CarrinhoModel> buscaPorId(Long id);
}
