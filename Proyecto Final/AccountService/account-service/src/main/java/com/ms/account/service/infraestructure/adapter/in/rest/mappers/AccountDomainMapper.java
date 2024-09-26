package com.ms.account.service.infraestructure.adapter.in.rest.mappers;

import com.ms.account.service.server.models.Account;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AccountDomainMapper {
    com.ms.account.service.domain.models.Account toAccountDomain (Account account);

    Account toAccount (com.ms.account.service.domain.models.Account account);
}
