package com.academiacx.repository;

import com.academiacx.model.CarrinhoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarrinhoRepository extends JpaRepository<CarrinhoModel, Long> {

}
