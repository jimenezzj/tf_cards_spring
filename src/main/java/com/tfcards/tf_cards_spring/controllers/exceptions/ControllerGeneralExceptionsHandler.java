package com.tfcards.tf_cards_spring.controllers.exceptions;

import com.tfcards.tf_cards_spring.exceptions.NotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
@Slf4j
public class ControllerGeneralExceptionsHandler {
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(NotFoundException.class)
    public ModelAndView handleNotFound(Exception ex) {
        log.error("Handling not found exception");
        log.error(ex.getMessage());
        var modelView = new ModelAndView();
        modelView.setViewName("404_not_found");
        modelView.addObject("ex", ex);
        return modelView;
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler({NumberFormatException.class})
    public ModelAndView handleNumberFormat(Exception ex) {
        log.error("Handling number format exception");
        log.error(ex.getMessage());
        var modelView = new ModelAndView();
        modelView.setViewName("400_bad_request");
        modelView.addObject("ex", ex);
        return modelView;
    }

}