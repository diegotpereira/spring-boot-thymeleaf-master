package br.com.java.springbootthymeleafmaster.util;

import org.springframework.data.domain.Page;
import br.com.java.springbootthymeleafmaster.model.Produto;

public class Pager {

    private final Page<Produto> produtos;

    public Pager(Page<Produto>produtos){
        this.produtos = produtos;
    }

    public int getPageIndex(){
        return produtos.getNumber() + 1;
    }

    public int getPageSize(){
        return produtos.getSize();
    }

    public boolean hasNext(){
        return produtos.hasNext();
    }

    public boolean hasPrevious(){
        return produtos.hasPrevious();
    }

    public int getTotalPages(){
        return produtos.getTotalPages();
    }

    public long getTotalElements(){
        return produtos.getTotalElements();
    }
    public boolean indexOutOfBounds() {
        return this.getPageIndex() < 0 || this.getPageIndex() > this.getTotalElements();
    }
}
