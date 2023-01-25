package com.cx.academy.exerciciontt.repository;

import com.cx.academy.exerciciontt.model.ItemModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<ItemModel, Long> {

}
