package com.example.academiacx2.repository;

import com.example.academiacx2.model.ItemModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface ItemRepository extends JpaRepository<ItemModel, Long> {
    Optional<ItemModel> findByQuantidadeAndTotal(Integer quantidade, Double total);

    Optional<List<ItemModel>> findByQuantidadeOrTotal(Integer quantidade, Double total);

    //QUERRY
    @Query("SELECT itemModel FROM ItemModel AS itemModel WHERE itemModel.id = ?1")
    Optional<ItemModel> buscaPorId(Long id);
}
