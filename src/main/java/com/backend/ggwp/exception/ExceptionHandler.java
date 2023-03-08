package com.backend.ggwp.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ResponseStatus;

@Slf4j
@ControllerAdvice
public class ExceptionHandler {
    @org.springframework.web.bind.annotation.ExceptionHandler({NoSuchPostFoundException.class, ApiServerNoSuchDataException.class})
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String notfound404() {
        log.info("404 error");
        return "error/404";
    }

    @org.springframework.web.bind.annotation.ExceptionHandler({InvalidApiKeyException.class})
    @ResponseStatus(HttpStatus.SERVICE_UNAVAILABLE)
    public String invalidApiKey() {
        log.info("503 error");
        return "error/503";
    }


    @org.springframework.web.bind.annotation.ExceptionHandler({Exception.class, ApiServerException.class})
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public String internal500() {
        log.info("500 error");
        return "error/5xx";
    }
}
