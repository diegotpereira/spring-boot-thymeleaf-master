package br.com.java.springbootthymeleafmaster.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class GlobalExceptionHandler {
    
    private static Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(Throwable.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ModelAndView exception(final Throwable throwable, final Model model){
        logger.error("Exceção durante a execução do aplicativo SpringSecurity", throwable);

        ModelAndView modelAndView = new ModelAndView("/error");
        String errorMessage = (throwable != null ? throwable.toString() : "Erro desconhecido");
        modelAndView.addObject("errorMessage", errorMessage);

        return modelAndView;
    }
}
