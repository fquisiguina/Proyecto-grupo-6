package com.ms.account.middleend.service.impl;

import com.ms.account.middleend.client.AccountServiceClient;
import com.ms.account.middleend.domain.Account;
import com.ms.account.middleend.domain.Movement;
import com.ms.account.middleend.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService {

    private final AccountServiceClient accountServiceClient;

    @Override
    public Account createAccount(String xSwClientRequestId,
                                 String xCmClientUserAgent,
                                 Account account) {
        return accountServiceClient.createAccount(xSwClientRequestId, xCmClientUserAgent, account).getBody();
    }

    @Override
    public Account getAccountById(Long id,
                                  String xSwClientRequestId,
                                  String xCmClientUserAgent ) {
        return accountServiceClient.getAccountById(id, xSwClientRequestId, xCmClientUserAgent). getBody();
    }

    @Override
    public List<Account> getAccountsByCustomerId(Long id,
                                                 String xSwClientRequestId,
                                                 String xCmClientUserAgent) {
        return accountServiceClient.getAccountsByCustomerId(id, xSwClientRequestId, xCmClientUserAgent).getBody();
    }

    @Override
    public Account updateAccountMovement(Long id,
                                         String xSwClientRequestId,
                                         String xCmClientUserAgent,
                                         Movement movement) {
        return accountServiceClient.updateAccountMovement(id, xSwClientRequestId, xCmClientUserAgent, movement).getBody();
    }
}
