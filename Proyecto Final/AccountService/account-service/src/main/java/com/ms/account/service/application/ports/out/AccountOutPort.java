package com.ms.account.service.application.ports.out;

import com.ms.account.service.domain.models.Account;

public interface AccountOutPort {

    Account saveAccount (Account account);

    Account getById (Long id);
}
