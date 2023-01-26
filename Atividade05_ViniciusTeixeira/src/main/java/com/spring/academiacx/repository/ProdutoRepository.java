package com.spring.academiacx.repository;

import com.spring.academiacx.model.ProdutoModel;
import com.spring.academiacx.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface ProdutoRepository extends JpaRepository<ProdutoModel, Long> {


    @Query("SELECT produtoModel FROM ProdutoModel AS produtoModel WHERE produtoModel.id = ?1")
    Optional<ProdutoModel> buscaPorId(Long id);
}