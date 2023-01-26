package com.ecommerce.igorfilgueira.repository;
import com.ecommerce.igorfilgueira.model.PrecoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PrecoRepository extends JpaRepository<PrecoModel, Long> {

}