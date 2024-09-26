package com.ms.account.service.domain.models;

import lombok.Data;

import java.time.OffsetDateTime;

@Data
public class Movement {
    private Double amount;

    private String user;
}
