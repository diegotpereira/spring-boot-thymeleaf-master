package br.com.java.springbootthymeleafmaster.service;

import java.math.BigDecimal;
import java.util.Map;

import br.com.java.springbootthymeleafmaster.exception.produtoSemEstoque;
import br.com.java.springbootthymeleafmaster.model.Produto;

public interface carrinhoDeComprasService {
    
    void addProduto(Produto produto);

    void removerProduto(Produto produto);

    Map<Produto, Integer> getProdutosNoCarrinho();

    void verificar() throws produtoSemEstoque;

    BigDecimal getTotal();
}
