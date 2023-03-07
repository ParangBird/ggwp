package com.backend.ggwp.exception;

public class ApiServerException extends RuntimeException {
    public ApiServerException() {

    }

    public ApiServerException(String message) {
        super(message);
    }
}
