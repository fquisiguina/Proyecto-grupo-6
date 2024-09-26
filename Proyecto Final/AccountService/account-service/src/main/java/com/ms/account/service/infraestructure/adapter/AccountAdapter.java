package com.ms.account.service.infraestructure.adapter;

import com.ms.account.service.application.ports.out.AccountOutPort;
import com.ms.account.service.domain.exceptions.AccountNotFoundException;
import com.ms.account.service.domain.models.Account;
import com.ms.account.service.infraestructure.adapter.out.account.entity.AccountEntity;
import com.ms.account.service.infraestructure.adapter.out.account.repository.AccountRepository;
import com.ms.account.service.infraestructure.adapter.out.account.repository.mappers.AccountMapperM;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class AccountAdapter implements AccountOutPort {

    private final AccountRepository accountRepository;
    private final AccountMapperM accountMapperM = new AccountMapperM();


    @Override
    public Account saveAccount(Account account) {
        AccountEntity accountEntity = accountMapperM.toAccountEntity(account);
        accountEntity.setDateCreate(new Date());
        accountEntity.setUserCreates(account.getUser());
        accountEntity.setStatus(true);

        return accountMapperM.toAccount(accountRepository.save(accountEntity));
    }


    @Override
    public Account getById(Long id)  {


        Optional<AccountEntity> optional = accountRepository.findById(id);

        if (optional.isPresent()) {
            AccountEntity accountEntity = optional.get();
            return  accountMapperM.toAccount(accountRepository.save(accountEntity));

        } else {
            throw new AccountNotFoundException("Account not found");
        }
    }


}
