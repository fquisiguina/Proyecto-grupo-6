package com.ms.account.service.infraestructure.adapter;

import com.ms.account.service.application.ports.out.AccountOutPort;
import com.ms.account.service.domain.exceptions.AccountNotFoundException;
import com.ms.account.service.domain.exceptions.NotUpdateAmountException;
import com.ms.account.service.domain.models.Account;
import com.ms.account.service.domain.models.Movement;
import com.ms.account.service.infraestructure.adapter.out.account.entity.AccountEntity;
import com.ms.account.service.infraestructure.adapter.out.account.repository.AccountRepository;
import com.ms.account.service.infraestructure.adapter.out.account.repository.mappers.AccountMapperM;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
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

    @Override
    public Account updateAccount(Long id, Movement movement) {
        Optional<AccountEntity> optional = accountRepository.findById(id);

        if (optional.isPresent()) {
            try {
            AccountEntity accountEntity = optional.get();
            accountEntity.setAmount(movement.getAmount());
            //accountEntity.setAmount(Double.parseDouble("a"));
            accountEntity.setUserModifies(movement.getUser());
            accountEntity.setDateModifies(new Date());


                return accountMapperM.toAccountUpdate(accountRepository.save(accountEntity));
            } catch(Exception ex){
                throw  new NotUpdateAmountException("Conflicto al actualizar el amount de la cuenta");
            }

        } else {
            throw new AccountNotFoundException("Account not found");
        }
    }


    @Override
    public List<Account> getAccountByIdCustomer(Long id) {
        List<Account> result;
        List<AccountEntity> list = accountRepository.findAccountsByCustomerId(id);
        if (list == null || list.isEmpty()) {
            throw new AccountNotFoundException("customer does not have an account");
        } else {
            result = new ArrayList<>();
            for (AccountEntity accountEntity : list) {
                result.add(accountMapperM.toAccount(accountRepository.save(accountEntity)));
            }
            return result;
        }
    }


}
