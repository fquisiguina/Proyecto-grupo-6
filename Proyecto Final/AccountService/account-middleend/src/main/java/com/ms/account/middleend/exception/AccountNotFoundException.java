package com.ms.account.middleend.exception;

public class AccountNotFoundException extends RuntimeException {

    public AccountNotFoundException (String message) {
        super(message);
    }
}
