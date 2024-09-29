package com.ms.movement.service.application.ports.out;


import com.ms.movement.service.domain.models.Movement;

import java.util.List;

public interface MovementOutPort {
    Movement save(Movement movement);

    List<Movement> getMovementsByAccount(Long accountId);
}
