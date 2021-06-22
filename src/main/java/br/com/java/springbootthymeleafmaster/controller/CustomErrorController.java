package br.com.java.springbootthymeleafmaster.controller;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CustomErrorController implements ErrorController{

    private static final String PATH = "/error";

    @RequestMapping(PATH)
    public ModelAndView error(){
        return new ModelAndView("/error");
    }

    @GetMapping("/403")
    public ModelAndView error403(){
        return new ModelAndView("/403");
    }

    @Override
    public String getErrorPath (){
        return PATH;
    }
}
