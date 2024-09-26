package com.ms.account.service.application.ports.out;

import com.ms.account.service.domain.exceptions.AccountNotFoundException;
import com.ms.account.service.domain.models.Account;
import com.ms.account.service.domain.models.Movement;

import java.util.List;

public interface AccountOutPort {

    Account saveAccount (Account account);

    Account getById (Long id);

    Account updateAccount(Long id, Movement movement);

    List<Account> getAccountByIdCustomer (Long id);
}
