package br.com.java.springbootthymeleafmaster.service.impl;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.WebApplicationContext;

import br.com.java.springbootthymeleafmaster.exception.produtoSemEstoque;
import br.com.java.springbootthymeleafmaster.model.Produto;
import br.com.java.springbootthymeleafmaster.repository.ProdutoRepository;
import br.com.java.springbootthymeleafmaster.service.carrinhoDeComprasService;

@Service
@Scope(value= WebApplicationContext.SCOPE_SESSION, proxyMode = ScopedProxyMode.TARGET_CLASS)
@Transactional
public class carrinhoDeComprasServiceImpl implements carrinhoDeComprasService{

    private final ProdutoRepository produtoRepository;

    private Map<Produto, Integer> produtos = new HashMap<>();

    @Autowired
    public carrinhoDeComprasServiceImpl(ProdutoRepository produtoRepository){
        this.produtoRepository = produtoRepository;
    }

    @Override
    public void addProduto(Produto produto) {
        // TODO Auto-generated method stub

        if (produtos.containsKey(produto)) {
            produtos.replace(produto, produtos.get(produto) + 1);
        } else {
            produtos.put(produto, 1);
        }
        
    }

    @Override
    public void removerProduto(Produto produto) {
        // TODO Auto-generated method stub
        
        if (produtos.containsKey(produto)) {
            if (produtos.get(produto) > 1) {
                produtos.replace(produto, produtos.get(produto) -1) ;
            } else {
                produtos.remove(produto);
            }
        }
    }

    @Override
    public Map<Produto, Integer> getProdutosNoCarrinho() {
        // TODO Auto-generated method stub
        return Collections.unmodifiableMap(produtos);
    }

    @Override
    public void verificar() throws produtoSemEstoque {
        // TODO Auto-generated method stub
      /*  Produto produto;

        for(Map.Entry<Produto, Integer> entry : produtos.entrySet()){
            produto = produtoRepository.findOne(entry.getKey().getId());

            if (produto.getQuantidade() < entry.getValue())
                throw new produtoSemEstoque(produto);

                entry.getKey().setQuantidade(produto.getQuantidade() - entry.getValue());
            }

            produtoRepository.save(produtos.keySet());
            produtoRepository.flush();
            produtos.clear(); */
        } 
    

    @Override
    public BigDecimal getTotal() {
        // TODO Auto-generated method stub
        return produtos.entrySet().stream().map(entry->entry.getKey().getPreco().multiply(BigDecimal.valueOf(entry.getValue()))).reduce(BigDecimal::add).orElse(BigDecimal.ZERO);
    }
    
}
