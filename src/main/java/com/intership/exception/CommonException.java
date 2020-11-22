package com.intership.exception;

public class CommonException extends RuntimeException {
    private final String message;

    public CommonException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
