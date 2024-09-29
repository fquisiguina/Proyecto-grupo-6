package com.ms.account.middleend.service;

import com.ms.account.middleend.domain.Account;
import com.ms.account.middleend.domain.Movement;

import java.util.List;

public interface AccountService {

    Account createAccount(String xSwClientRequestId,
                          String xCmClientUserAgent,
                          Account account);

    Account getAccountById(Long id,
                           String xSwClientRequestId,
                           String xCmClientUserAgent );

    List<Account> getAccountsByCustomerId(Long id,
                                          String xSwClientRequestId,
                                          String xCmClientUserAgent);

    Account updateAccountMovement(Long id,
                                  String xSwClientRequestId,
                                  String xCmClientUserAgent,
                                  Movement movement);


}
