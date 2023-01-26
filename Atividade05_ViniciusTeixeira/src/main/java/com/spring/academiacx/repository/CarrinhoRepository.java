package com.spring.academiacx.repository;

import com.spring.academiacx.model.CarrinhoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface CarrinhoRepository extends JpaRepository<CarrinhoModel, Long> {
    @Query("SELECT carrinhoModel FROM CarrinhoModel AS carrinhoModel WHERE carrinhoModel.id = ?1")
    Optional<CarrinhoModel> buscaPorId(Long id);
}
