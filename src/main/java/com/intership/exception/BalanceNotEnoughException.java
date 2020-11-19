package com.intership.exception;

public class BalanceNotEnoughException extends CommonException {
    private String message;


    public BalanceNotEnoughException(String message) {
        super(message);
    }
}
