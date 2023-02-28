package com.backend.ggwp.domain.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ExceptionHandler {
    @org.springframework.web.bind.annotation.ExceptionHandler(NoSuchPostFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String notfound404(){
        return "error/404";
    }

    @org.springframework.web.bind.annotation.ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public String internal500(){
        return "error/5xx";
    }
}
