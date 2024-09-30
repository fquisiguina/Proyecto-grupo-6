package com.ms.account.service.application.ports.in;

import com.ms.account.service.domain.models.Account;
import com.ms.account.service.domain.models.Amount;

import java.util.List;

public interface AccountInPort {

    Account saveAccount (String xSwClientRequestId, String xCmClientUserAgent, Account account);

    Account getById (Long id);

    Account updateAccount(Long id, Amount amount);

    List<Account> getAccountByIdCustomer (Long id);
}
