package com.backend.ggwp.exception;

public class ApiKeyExpiredException extends RuntimeException {
    public ApiKeyExpiredException() {

    }

    public ApiKeyExpiredException(String message) {
        super(message);
    }
}
