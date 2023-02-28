package com.backend.ggwp.domain.exception;

public class NoSuchPostFoundException extends RuntimeException {
    public NoSuchPostFoundException() {

    }

    public NoSuchPostFoundException(String message) {
        super(message);
    }
}
