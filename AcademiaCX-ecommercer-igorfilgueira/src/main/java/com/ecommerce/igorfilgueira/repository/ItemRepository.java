package com.ecommerce.igorfilgueira.repository;
import com.ecommerce.igorfilgueira.model.ItemModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepository extends JpaRepository<ItemModel, Long> {

}