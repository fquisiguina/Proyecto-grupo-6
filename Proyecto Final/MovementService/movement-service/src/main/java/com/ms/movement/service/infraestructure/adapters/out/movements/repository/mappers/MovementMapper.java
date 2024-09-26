package com.ms.movement.service.infraestructure.adapters.out.movements.repository.mappers;

import com.ms.movement.service.domain.Movement;
import com.ms.movement.service.infraestructure.adapters.out.movements.entity.MovementEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MovementMapper {
    MovementEntity toMovementEntity(Movement movement);

    Movement toMovement(MovementEntity movementEntity);
}
