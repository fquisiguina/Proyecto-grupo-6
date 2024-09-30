package com.ms.account.service.infraestructure.adapter.in.rest.mappers;

import com.ms.account.service.server.models.Amount;

import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AmountDomainMapper {
    com.ms.account.service.domain.models.Amount toAmountDomain (Amount amount);

    Amount toMovement (com.ms.account.service.domain.models.Amount amount);
}
