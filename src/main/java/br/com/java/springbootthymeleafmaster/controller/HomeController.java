package br.com.java.springbootthymeleafmaster.controller;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import br.com.java.springbootthymeleafmaster.model.Produto;
import br.com.java.springbootthymeleafmaster.service.ProdutoService;
import br.com.java.springbootthymeleafmaster.util.Pager;


@Controller
public class HomeController {
   /* @GetMapping("/")
    public String home() {
        return "/home";
    }*/

    private static final int INITIAL_PAGE = 0;

    private final ProdutoService produtoService;

    public HomeController(ProdutoService produtoService){
        this.produtoService = produtoService;
    }

    @GetMapping("/home")
    public ModelAndView home(@RequestParam("page") Optional<Integer> page, Pageable pageRequest) {

        int evalPage = (page.orElse(0) < 1) ? INITIAL_PAGE : page.get() - 1;

        Page<Produto> produtos = produtoService.findAllProductsPageable(pageable, pageRequest)
        Pager pager = new Pager(produtos);


        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("produtos", produtos);
        modelAndView.addObject("pager", pager);
        modelAndView.setViewName("/home");
        return modelAndView;
    }
}