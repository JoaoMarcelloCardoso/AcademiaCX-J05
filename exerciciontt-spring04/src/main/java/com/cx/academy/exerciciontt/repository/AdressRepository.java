package com.cx.academy.exerciciontt.repository;

import com.cx.academy.exerciciontt.model.AddressModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdressRepository extends JpaRepository<AddressModel, Long> {

}
