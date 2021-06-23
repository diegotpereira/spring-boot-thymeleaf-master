package br.com.java.springbootthymeleafmaster.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import br.com.java.springbootthymeleafmaster.model.User;

public interface UserRepository extends JpaRepository<User, Long>{
    Optional<User> findByEmail(@Param("email") String email);

    Optional<User> findByUsername (@Param("username") String username);
}
