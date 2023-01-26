package com.demo.academiacx.repository;

import com.demo.academiacx.model.CarrinhoModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarrinhoRepository extends JpaRepository<CarrinhoModel, Long> {
}
