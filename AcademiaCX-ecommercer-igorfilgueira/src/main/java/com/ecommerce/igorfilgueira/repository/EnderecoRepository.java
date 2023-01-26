package com.ecommerce.igorfilgueira.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.ecommerce.igorfilgueira.model.EnderecoModel;
@Repository
public interface EnderecoRepository extends JpaRepository<EnderecoModel, Long> {

}
