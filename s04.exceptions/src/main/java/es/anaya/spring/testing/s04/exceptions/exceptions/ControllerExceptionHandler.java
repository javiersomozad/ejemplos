package es.anaya.spring.testing.s04.exceptions.exceptions;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

@Slf4j
@ControllerAdvice
public class ControllerExceptionHandler {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(NumberFormatException.class)
    public ModelAndView handleNumberFormat(Exception exception){

        log.error("Number format exception: " + exception.getMessage());

        ModelAndView modelAndView = new ModelAndView();

        modelAndView.setViewName("numberFormatException");
        modelAndView.addObject("exception", exception);

        return modelAndView;
    }
}