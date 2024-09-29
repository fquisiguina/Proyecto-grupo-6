package com.msa.customer.service.domain.exceptions;

public class CustomerNotFoundException extends RuntimeException {

    public CustomerNotFoundException (String message) {
        super(message);
    }
}