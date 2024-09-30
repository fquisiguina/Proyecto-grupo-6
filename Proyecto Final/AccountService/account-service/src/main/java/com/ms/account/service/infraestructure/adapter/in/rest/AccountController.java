package com.ms.account.service.infraestructure.adapter.in.rest;

import com.ms.account.service.application.ports.in.AccountInPort;
import com.ms.account.service.infraestructure.adapter.in.rest.mappers.AccountDomainMapper;
import com.ms.account.service.infraestructure.adapter.in.rest.mappers.AmountDomainMapper;
import com.ms.account.service.server.models.Account;
import com.ms.account.service.server.models.Amount;
import com.ms.customer.service.server.AccountsApi;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class AccountController implements AccountsApi{

    private final AccountInPort accountInPort;
    private final AccountDomainMapper accountDomainMapper;
    private final AmountDomainMapper amountDomainMapper;

    @Override
    @CrossOrigin
    public ResponseEntity<Account> createAccount(String xSwClientRequestId, String xCmClientUserAgent, Account account) {
        return new ResponseEntity<>(
                accountDomainMapper.toAccount(
                        accountInPort.saveAccount(
                                xSwClientRequestId, xCmClientUserAgent, accountDomainMapper.toAccountDomain(account)
                        )
                ), HttpStatus.CREATED);
    }

    @Override
    @CrossOrigin
    public ResponseEntity<Account> getAccountById(Long id, String xSwClientRequestId, String xCmClientUserAgent) {
            com.ms.account.service.domain.models.Account account = accountInPort.getById(id);
            return new ResponseEntity<>(accountDomainMapper.toAccount(account), HttpStatus.OK);
    }


    @Override
    @CrossOrigin
    public ResponseEntity<List<Account>> getAccountsByCustomerId(Long id, String xSwClientRequestId, String xCmClientUserAgent) {
        List<com.ms.account.service.domain.models.Account> list = accountInPort.getAccountByIdCustomer(id);
        List<Account> result = new ArrayList<>();
        for (com.ms.account.service.domain.models.Account account : list) {
            result.add(accountDomainMapper.toAccount(account));
        }

        return new ResponseEntity<>(result, HttpStatus.OK);
    }



    @Override
    @CrossOrigin
    public ResponseEntity<Account> updateAccountMovement(Long id,
                                                         String xSwClientRequestId,
                                                         String xCmClientUserAgent,
                                                         Amount amount) {
        return new ResponseEntity<>(
                accountDomainMapper.toAccount(
                        accountInPort.updateAccount(
                                id,
                                amountDomainMapper.toAmountDomain(amount)
                        )
                ), HttpStatus.OK);
    }




}
