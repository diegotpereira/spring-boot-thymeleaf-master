package br.com.java.springbootthymeleafmaster.exception;

import br.com.java.springbootthymeleafmaster.model.Produto;

public class produtoSemEstoque extends Exception{
    
    private static final String DEFAULT_MESSAGE = "Esse produto não tem estoque";

    public produtoSemEstoque(){
        super(DEFAULT_MESSAGE);
    }

    public produtoSemEstoque(Produto produto){
        super(String.format("Esse produto %s não tem estoque. Restam %d apenas", produto.getNome(), produto.getQuantidade()));
    }
}
