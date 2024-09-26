package com.ms.movement.service.application.ports.out;


import com.ms.movement.service.domain.Movement;

public interface MovementOutPort {
    Movement save(Movement movement);
}
