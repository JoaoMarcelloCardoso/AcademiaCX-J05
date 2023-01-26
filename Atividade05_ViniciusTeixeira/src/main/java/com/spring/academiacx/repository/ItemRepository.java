package com.spring.academiacx.repository;

import com.spring.academiacx.model.ItemModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface ItemRepository extends JpaRepository<ItemModel, Long> {

    @Query("SELECT itemModel FROM ItemModel AS itemModel WHERE itemModel.id = ?1")
    Optional<ItemModel> buscaPorId(Long id);
}
