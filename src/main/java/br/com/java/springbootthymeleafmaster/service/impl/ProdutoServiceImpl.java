package br.com.java.springbootthymeleafmaster.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.java.springbootthymeleafmaster.model.Produto;
import br.com.java.springbootthymeleafmaster.repository.ProdutoRepository;
import br.com.java.springbootthymeleafmaster.service.ProdutoService;

@Service
public class ProdutoServiceImpl implements ProdutoService{

    private final ProdutoRepository produtoRepository;

    @Autowired
    public ProdutoServiceImpl(ProdutoRepository produtoRepository){
        this.produtoRepository = produtoRepository;
    }

    @Override
    public Optional<Produto> findById(Long id) {
        // TODO Auto-generated method stub
        return produtoRepository.findById(id);
    }

    @Override
    public Page<Produto> findAllProductsPageable(Pageable pageable) {
        // TODO Auto-generated method stub
        return produtoRepository.findAll(pageable);
    }
    
}
