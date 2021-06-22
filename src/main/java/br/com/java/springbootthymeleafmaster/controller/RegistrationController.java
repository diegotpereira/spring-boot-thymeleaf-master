package br.com.java.springbootthymeleafmaster.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class RegistrationController {

    @GetMapping(value = "/registration")
    public ModelAndView registration(){
        ModelAndView modelAndView = new ModelAndView("/registration");
        return modelAndView;
    }
}
