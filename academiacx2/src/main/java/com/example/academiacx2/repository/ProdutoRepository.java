package com.example.academiacx2.repository;

import com.example.academiacx2.model.ProdutoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface ProdutoRepository extends JpaRepository<ProdutoModel, Long> {

    Optional<ProdutoModel> findBySkuAndNome(String sku, String nome);

    Optional<List<ProdutoModel>> findBySkuOrNome(String sku, String nome);

    //QUERRY
    @Query("SELECT produtoModel FROM ProdutoModel AS produtoModel WHERE produtoModel.id = ?1")
    Optional<ProdutoModel> buscaPorId(Long id);
}
