package com.ms.movement.service.application.service;

import com.ms.movement.service.application.ports.in.MovementInPort;
import com.ms.movement.service.application.ports.out.MovementOutPort;
import com.ms.movement.service.domain.TypeMovementEnum;
import com.ms.movement.service.domain.models.Account;
import com.ms.movement.service.domain.models.Movement;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MovementService implements MovementInPort {
    private final MovementOutPort movementOutPort;
    private final AccountService accountService;

    @Override
    public Movement createMovement(String xSwClientRequestId, String xSwClientUserAgent, Movement movement) {
        Account account = accountService.getAccount(xSwClientRequestId, xSwClientUserAgent, movement.getAccountId());
        validateMovement(movement, account);
        Account accountOut = accountService.processTransaction(xSwClientRequestId, xSwClientUserAgent, account, movement);

        return movementOutPort.save(movement);
    }

    @Override
    public List<Movement> getMovementsByAccount(Long accountId) {
        return movementOutPort.getMovementsByAccount(accountId);
    }

    private void validateMovement(Movement movement, Account account) {
        if (movement.getAmount() <= 0) {
            throw new RuntimeException("No es posible realizar transacción con monto " + movement.getAmount());
        }

        if (movement.getTypeMovement().equals(TypeMovementEnum.RETIRO) && movement.getAmount() > account.getAmount()) {
            throw new IllegalArgumentException("No existe fondos suficientes en la cuenta.");
        }
    }
}
