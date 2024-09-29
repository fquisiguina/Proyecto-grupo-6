package com.ms.account.service.application.service;

import com.ms.account.service.application.ports.in.AccountInPort;
import com.ms.account.service.application.ports.out.AccountOutPort;
import com.ms.account.service.domain.models.Account;
import com.ms.account.service.domain.models.Customer;
import com.ms.account.service.domain.models.Movement;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AccountService implements AccountInPort {

    private final AccountOutPort accountOutPort;

    private final CustomerService customerService;

    @Override
    public Account saveAccount(String xSwClientRequestId, String xCmClientUserAgent, Account account) {

        System.out.println("Ingreso");
        Customer customer = customerService.getCustomerById(account.getCustomerId(),  xSwClientRequestId, xCmClientUserAgent);
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
