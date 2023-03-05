package com.backend.ggwp.exception;

public class NoSuchPostFoundException extends RuntimeException {
    public NoSuchPostFoundException() {

    }

    public NoSuchPostFoundException(String message) {
        super(message);
    }
}
