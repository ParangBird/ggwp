package com.backend.ggwp.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ResponseStatus;

@Slf4j
@ControllerAdvice
public class ExceptionHandler {
    @org.springframework.web.bind.annotation.ExceptionHandler(NoSuchPostFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String noSuchPost(Exception e) {
        log.error("해당하는 게시물을 찾을 수 없음");
        log.error(e.toString());
        return "error/404";
    }

    @org.springframework.web.bind.annotation.ExceptionHandler(ApiServerNoSuchDataException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String noSuchApiData(Exception e) {
        log.error("해당하는 API 데이터를 찾을 수 없음");
        log.error(e.toString());
        return "error/404";
    }

    @org.springframework.web.bind.annotation.ExceptionHandler({InvalidApiKeyException.class})
    @ResponseStatus(HttpStatus.SERVICE_UNAVAILABLE)
    public String invalidApiKey(Exception e) {
        log.error("현재 API key 가 만료되었음");
        log.error(e.toString());
        return "error/503";
    }

    @org.springframework.web.bind.annotation.ExceptionHandler(ApiServerException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public String apiServerException(Exception e) {
        log.error("현재 API 서버에 오류가 있음");
        log.error(e.toString());
        return "error/5xx";
    }

    @org.springframework.web.bind.annotation.ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public String exception(Exception e) {
        log.error("정의되지 않은 범용적인 오류");
        log.error(e.toString());
        return "error/5xx";
    }
}
