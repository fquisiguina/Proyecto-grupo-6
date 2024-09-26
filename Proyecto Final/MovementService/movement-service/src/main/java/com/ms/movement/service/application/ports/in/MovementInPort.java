package com.ms.movement.service.application.ports.in;


import com.ms.movement.service.domain.Movement;

import java.util.List;

public interface MovementInPort {
    Movement createMovement(Movement movement);

    List<Movement> getMovementsByAccount(String accountId);
}
