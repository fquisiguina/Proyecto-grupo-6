package com.ms.account.service.application.ports.in;

import com.ms.account.service.domain.exceptions.AccountNotFoundException;
import com.ms.account.service.domain.models.Account;
import com.ms.account.service.domain.models.Movement;

import java.util.List;

public interface AccountInPort {

    Account saveAccount (Account account);

    Account getById (Long id);

    Account updateAccount(Long id, Movement movement);

    List<Account> getAccountByIdCustomer (Long id);
}
