package com.backend.ggwp.exception;

public class ApiServerNoSuchDataException extends RuntimeException {
    public ApiServerNoSuchDataException() {

    }

    public ApiServerNoSuchDataException(String message) {
        super(message);
    }
}
