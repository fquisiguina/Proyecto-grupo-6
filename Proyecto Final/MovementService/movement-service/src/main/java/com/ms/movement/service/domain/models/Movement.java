package com.ms.movement.service.domain.models;

import com.ms.movement.service.domain.TypeMovementEnum;
import lombok.Data;

@Data
public class Movement {
    private Long id;

    private TypeMovementEnum typeMovement;

    private Double amount;

    private Long accountId;
}
