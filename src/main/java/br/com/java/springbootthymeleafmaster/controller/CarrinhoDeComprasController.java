package br.com.java.springbootthymeleafmaster.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CarrinhoDeComprasController {
    
    @GetMapping("/carrinhoDeCompras")
    public ModelAndView carrinhoDeCompras(){
        ModelAndView modelAndView = new ModelAndView("/carrinhoDeCompras");
        return modelAndView;
    }
}
