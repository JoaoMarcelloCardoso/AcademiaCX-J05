package com.ecommerce.igorfilgueira.repository;
import com.ecommerce.igorfilgueira.model.ClienteModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<ClienteModel, Long> {

}

