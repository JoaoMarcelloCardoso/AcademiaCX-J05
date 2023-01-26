package com.spring.academiacx.repository;

import com.spring.academiacx.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<UserModel, Long> {

    Optional<UserModel> findByUsername(String username);

    @Query("SELECT userModel FROM UserModel AS userModel WHERE userModel.id = ?1")
    Optional<UserModel> buscaPorId(Long id);
}
