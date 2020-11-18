package com.intership.exception;

public class BalanceNotEnoughException extends RuntimeException {
    private String message;

    public BalanceNotEnoughException(String message) {
        this.message = message;
    }
}
