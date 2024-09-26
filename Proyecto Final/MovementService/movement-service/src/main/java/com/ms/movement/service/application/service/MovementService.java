package com.ms.movement.service.application.service;

import com.ms.movement.service.application.ports.in.MovementInPort;
import com.ms.movement.service.application.ports.out.MovementOutPort;
import com.ms.movement.service.domain.Movement;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MovementService implements MovementInPort {
    private final MovementOutPort movementOutPort;

    @Override
    public Movement createMovement(Movement movement) {
        return movementOutPort.save(movement);
    }

    @Override
    public List<Movement> getMovementsByAccount(String accountId) {
        return List.of();
    }
}
