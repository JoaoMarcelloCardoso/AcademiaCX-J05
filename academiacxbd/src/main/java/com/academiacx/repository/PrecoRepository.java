package com.academiacx.repository;

import com.academiacx.models.PrecoModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PrecoRepository extends JpaRepository<PrecoModel, Long> {
}
