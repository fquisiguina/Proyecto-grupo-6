package com.ms.account.service.domain.exceptions;

public class AccountNotFoundException extends RuntimeException {

    public AccountNotFoundException (String message) {
        super(message);
    }
}
