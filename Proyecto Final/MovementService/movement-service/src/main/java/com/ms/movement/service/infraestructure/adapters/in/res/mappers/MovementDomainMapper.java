package com.ms.movement.service.infraestructure.adapters.in.res.mappers;

import com.ms.movement.service.domain.Movement;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MovementDomainMapper {
    Movement toMovementDomain(com.ms.movement.service.server.models.Movement movement);

    com.ms.movement.service.server.models.Movement toMovement(Movement movement);
}