package com.demo.academiacx.repository;

import com.demo.academiacx.model.ClienteModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepostory extends JpaRepository<ClienteModel, Long> {
}
