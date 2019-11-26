package com.iris.pbms.Controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class GlobalExceptionController {

    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public ModelAndView handleError405(HttpServletRequest request, Exception e) {
        ModelAndView mav = new ModelAndView("LoginForm");
        return mav;
    }
    
    @ExceptionHandler(java.lang.IndexOutOfBoundsException.class)
    public ModelAndView handleError500(HttpServletRequest request, Exception e) {
        ModelAndView mav = new ModelAndView("Admin");
        mav.addObject("msg","Selected role not configured yet!");
        return mav;
    }
    
    @ExceptionHandler(Exception.class)
    public ModelAndView handleAllerror(HttpServletRequest request, Exception e) {
        ModelAndView mav = new ModelAndView("HomePage");
        mav.addObject("msg","Some Unknown error occured!");
        return mav;
    }
    
}
