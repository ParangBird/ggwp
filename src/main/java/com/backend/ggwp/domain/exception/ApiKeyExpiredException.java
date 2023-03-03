package com.backend.ggwp.domain.exception;

public class ApiKeyExpiredException extends RuntimeException {
    public ApiKeyExpiredException() {

    }

    public ApiKeyExpiredException(String message) {
        super(message);
    }
}
