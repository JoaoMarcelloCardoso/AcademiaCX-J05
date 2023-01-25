package com.cx.academy.exerciciontt.repository;

import com.cx.academy.exerciciontt.model.CartModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepository extends JpaRepository<CartModel, Long> {
}
