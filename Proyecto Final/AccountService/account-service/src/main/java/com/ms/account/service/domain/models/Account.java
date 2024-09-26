package com.ms.account.service.domain.models;

import lombok.Data;

import java.time.OffsetDateTime;

@Data
public class Account {
    private Long id;

    private String numberAccount;

    private String currencyType;

    private Double amount;

    private Long customerId;

    private String user;

    private OffsetDateTime date;
}
