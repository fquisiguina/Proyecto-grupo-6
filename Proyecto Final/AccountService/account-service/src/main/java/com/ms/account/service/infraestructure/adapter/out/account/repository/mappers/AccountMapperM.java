package com.ms.account.service.infraestructure.adapter.out.account.repository.mappers;

import com.ms.account.service.domain.models.Account;
import com.ms.account.service.infraestructure.adapter.out.account.entity.AccountEntity;

import java.time.Instant;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;

public class AccountMapperM {

    public AccountEntity toAccountEntity(Account account) {
        AccountEntity entity = new AccountEntity();
        entity.setId(account.getId());
        entity.setNumberAccount(account.getNumberAccount());
        entity.setCurrencyType(account.getCurrencyType());
        entity.setAmount(account.getAmount());
        entity.setCustomerId(account.getCustomerId());
        return entity;
    }

    public Account toAccount(AccountEntity accountEntity) {
        Account account = new Account();
        account.setId(accountEntity.getId());
        account.setNumberAccount(accountEntity.getNumberAccount());
        account.setCurrencyType(accountEntity.getCurrencyType());
        account.setAmount(accountEntity.getAmount());
        account.setCustomerId(accountEntity.getCustomerId());
        account.setUser(accountEntity.getUserCreates());

        Instant instant = accountEntity.getDateCreate().toInstant();
        OffsetDateTime offsetDateTime = instant.atOffset(ZoneOffset.UTC);
        account.setDate(offsetDateTime);

        return account;
    }


}
