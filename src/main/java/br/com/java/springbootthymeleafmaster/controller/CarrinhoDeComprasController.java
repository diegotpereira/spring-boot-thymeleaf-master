package br.com.java.springbootthymeleafmaster.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

import br.com.java.springbootthymeleafmaster.exception.produtoSemEstoque;
import br.com.java.springbootthymeleafmaster.service.ProdutoService;
import br.com.java.springbootthymeleafmaster.service.carrinhoDeComprasService;

@Controller
public class CarrinhoDeComprasController {

    private final carrinhoDeComprasService carrinhoDeComprasService;

    private final ProdutoService produtoService;

    @Autowired
    public CarrinhoDeComprasController(carrinhoDeComprasService carrinhoDeComprasService, ProdutoService produtoService){
        this.carrinhoDeComprasService = carrinhoDeComprasService;
        this.produtoService = produtoService;
    }
    
    @GetMapping("/carrinhoDeCompras")
    public ModelAndView carrinhoDeCompras(){
        ModelAndView modelAndView = new ModelAndView("/carrinhoDeCompras");
        modelAndView.addObject("produtos", carrinhoDeComprasService.getProdutosNoCarrinho());
        modelAndView.addObject("total", carrinhoDeComprasService.getTotal().toString());
        return modelAndView;
    }

    @GetMapping("/carrinhoDeCompras/addProduto/{produtoId}")
    public ModelAndView addProdutoNoCarrinho(@PathVariable("produto_id") Long produtoId){
        produtoService.findById(produtoId).ifPresent(carrinhoDeComprasService::addProduto);
        return carrinhoDeCompras();
    }

    @GetMapping("/carrinhoDeCompras/removerProduto/{produtoId}")
    public ModelAndView removerProdutoDoCarrinho(@PathVariable("produtoId") Long ProdutoId){
        produtoService.findById(ProdutoId).ifPresent(carrinhoDeComprasService::removerProduto);

        return carrinhoDeCompras();
    }

    @GetMapping("/carrinhoDeCompras/verificar")
    public ModelAndView verificar(){
        try {
            carrinhoDeComprasService.verificar();
        } catch (produtoSemEstoque e) {
            //TODO: handle exception
            return carrinhoDeCompras().addObject("mensagemDeFaltaDeEstoque", e.getMessage());
        }

        return carrinhoDeCompras();
    }
}
