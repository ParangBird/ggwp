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
    public String notfound404(Exception e) {
        log.error(e.toString());
        return "error/404";
    }

    @org.springframework.web.bind.annotation.ExceptionHandler({InvalidApiKeyException.class})
    @ResponseStatus(HttpStatus.SERVICE_UNAVAILABLE)
    public String invalidApiKey(Exception e) {
        log.error(e.toString());
        return "error/503";
    }


    // TODO : 로그 찍히게
    @org.springframework.web.bind.annotation.ExceptionHandler({Exception.class, ApiServerException.class})
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public String internal500(Exception e) {
        log.error(e.toString());
        return "error/5xx";
    }
}
