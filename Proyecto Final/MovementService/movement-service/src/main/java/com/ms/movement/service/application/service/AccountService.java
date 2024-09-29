package com.ms.movement.service.application.service;

import com.ms.movement.service.application.ports.in.AccountInPort;
import com.ms.movement.service.domain.TypeMovementEnum;
import com.ms.movement.service.domain.models.Account;
import com.ms.movement.service.domain.models.Movement;
import com.ms.movement.service.infraestructure.adapters.out.repository.AccountServiceClient;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AccountService implements AccountInPort {
    private final AccountServiceClient accountServiceClient;

    public Account getAccount(String xSwClientRequestId, String xSwClientUserAgent, Long accountId) {
        ResponseEntity<Account> accountResponse = accountServiceClient.getAccountById(xSwClientRequestId, xSwClientUserAgent, accountId);
        if (accountResponse.getStatusCode().equals(HttpStatus.NO_CONTENT)) {
            throw new RuntimeException("La cuenta no existe");
        }

        return accountResponse.getBody();
    }

    public Account processTransaction(String xSwClientRequestId, String xSwClientUserAgent, Account accountIn, Movement movement) {
        double newAmount = calculateNewAmount(accountIn, movement);
        accountIn.setAmount(newAmount);
        ResponseEntity<Account> accountOut = accountServiceClient.updateAccount(xSwClientRequestId, xSwClientUserAgent, accountIn.getId(), accountIn);

        if (accountOut.getStatusCode() != HttpStatus.OK) {
            throw new RuntimeException("Error al actualizar la cuenta");
        }
        return accountOut.getBody();
    }

    private double calculateNewAmount(Account account, Movement movement) {
        double amount = account.getAmount();
        if (movement.getTypeMovement().equals(TypeMovementEnum.RETIRO)) {
            amount -= movement.getAmount();
        }

        if (movement.getTypeMovement().equals(TypeMovementEnum.DEPOSITO)) {
            amount += movement.getAmount();
        }
        return amount;
    }
}
