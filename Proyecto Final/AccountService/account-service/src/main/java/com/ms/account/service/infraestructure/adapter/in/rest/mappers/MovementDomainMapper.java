package com.ms.account.service.infraestructure.adapter.in.rest.mappers;

import com.ms.account.service.server.models.Movement;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MovementDomainMapper {
    com.ms.account.service.domain.models.Movement toMovementDomain (Movement movement);

    Movement toMovement (com.ms.account.service.domain.models.Movement movement);
}
