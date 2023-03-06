package com.backend.ggwp.exception;

public class InvalidApiKeyException extends RuntimeException {
    public InvalidApiKeyException() {

    }

    public InvalidApiKeyException(String message) {
        super(message);
    }
}
