package com.demo.academiacx.repository;

import com.demo.academiacx.model.PrecoModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PrecoRepository extends JpaRepository<PrecoModel, Long> {
}
