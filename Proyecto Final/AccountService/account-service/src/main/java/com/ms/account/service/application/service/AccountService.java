package com.ms.account.service.application.service;

import com.ms.account.service.application.ports.in.AccountInPort;
import com.ms.account.service.application.ports.out.AccountOutPort;
import com.ms.account.service.domain.exceptions.AccountNotFoundException;
import com.ms.account.service.domain.models.Account;
import com.ms.account.service.domain.models.Movement;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AccountService implements AccountInPort {

    private final AccountOutPort accountOutPort;


    @Override
    public Account saveAccount(Account account) {
        return accountOutPort.saveAccount(account);
    }

    @Override
    public Account getById(Long id) {
        return accountOutPort.getById(id);
    }

    @Override
    public Account updateAccount(Long id, Movement movement) {
        return accountOutPort.updateAccount(id, movement);
    }


    @Override
    public List<Account> getAccountByIdCustomer(Long id) {
        return accountOutPort.getAccountByIdCustomer(id);
    }


}
