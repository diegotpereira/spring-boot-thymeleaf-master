package br.com.java.springbootthymeleafmaster.controller;

import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.data.domain.Page;

@Controller
public class HomeController {
   /* @GetMapping("/")
    public String home() {
        return "/home";
    }*/

    private static final int INITIAL_PAGE = 0;

    @GetMapping("/home")
    public ModelAndView home(@RequestParam("page") Optional<Integer> page) {

        int evalPage = (page.orElse(0) < 1) ? INITIAL_PAGE : page.get() - 1;

        Page<Product> products = productService.findAllProductsPageable(new PageRequest(evalPage, 5));

        ModelAndView modelAndView = new ModelAndView();
        
        modelAndView.setViewName("/home");
        return modelAndView;
    }
}