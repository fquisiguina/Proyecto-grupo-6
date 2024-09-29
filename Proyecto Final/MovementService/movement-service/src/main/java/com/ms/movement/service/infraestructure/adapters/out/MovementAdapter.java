package com.ms.movement.service.infraestructure.adapters.out;

import com.ms.movement.service.application.ports.out.MovementOutPort;
import com.ms.movement.service.domain.models.Movement;
import com.ms.movement.service.infraestructure.adapters.out.entity.MovementEntity;
import com.ms.movement.service.infraestructure.adapters.out.repository.MovementRepository;
import com.ms.movement.service.infraestructure.adapters.out.repository.mappers.MovementMapper;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;

@Component
@RequiredArgsConstructor
public class MovementAdapter implements MovementOutPort {
    private final MovementRepository movementRepository;
    private final MovementMapper movementMapper;

    @Override
    public Movement save(Movement movement) {
        MovementEntity movementEntity = movementMapper.toMovementEntity(movement);
        movementEntity.setCreatedAt(LocalDateTime.now());
        MovementEntity movementResponse = movementRepository.save(movementEntity);
        return movementMapper.toMovement(movementResponse);
    }

    @Override
    public List<Movement> getMovementsByAccount(Long accountId) {
        return movementRepository.findByMovementsByAccountId(accountId)
                .stream().map(movementMapper::toMovement).toList();
    }
}
