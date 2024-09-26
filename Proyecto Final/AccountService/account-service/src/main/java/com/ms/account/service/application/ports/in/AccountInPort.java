package com.ms.account.service.application.ports.in;

import com.ms.account.service.domain.exceptions.AccountNotFoundException;
import com.ms.account.service.domain.models.Account;

public interface AccountInPort {

    Account saveAccount (Account account);

    Account getById (Long id);
}
