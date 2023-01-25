package com.cx.academy.exerciciontt.repository;

import com.cx.academy.exerciciontt.model.ProductModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<ProductModel, Long> {
}
