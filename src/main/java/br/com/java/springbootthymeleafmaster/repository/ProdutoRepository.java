package br.com.java.springbootthymeleafmaster.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.java.springbootthymeleafmaster.model.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
    Optional<Produto> findById(Long id);
}
