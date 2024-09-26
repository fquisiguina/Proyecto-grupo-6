package com.ms.movement.service.infraestructure.adapters.out.movements;

import com.ms.movement.service.application.ports.out.MovementOutPort;
import com.ms.movement.service.domain.Movement;
import com.ms.movement.service.infraestructure.adapters.out.movements.entity.MovementEntity;
import com.ms.movement.service.infraestructure.adapters.out.movements.repository.MovementRepository;
import com.ms.movement.service.infraestructure.adapters.out.movements.repository.mappers.MovementMapper;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class MovementAdapter implements MovementOutPort {
    private final MovementRepository movementRepository;
    private final MovementMapper movementMapper;

    @Override
    public Movement save(Movement movement) {
        MovementEntity movementEntity = movementMapper.toMovementEntity(movement);
        MovementEntity movementResponse = movementRepository.save(movementEntity);
        return movementMapper.toMovement(movementResponse);
    }
}
