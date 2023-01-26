package com.ecommerce.igorfilgueira.repository;
import com.ecommerce.igorfilgueira.model.ProdutoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoRepository extends JpaRepository<ProdutoModel, Long> {

}
