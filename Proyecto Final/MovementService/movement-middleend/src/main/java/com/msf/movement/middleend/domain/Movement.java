package com.msf.movement.middleend.domain;

import lombok.Data;

@Data
public class Movement {
    private Long id;

    private TypeMovementEnum typeMovement;

    private Double amount;

    private Long accountId;
}
