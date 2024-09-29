package com.ms.movement.service.application.service;

import com.ms.movement.service.application.ports.in.MovementInPort;
import com.ms.movement.service.application.ports.out.MovementOutPort;
import com.ms.movement.service.domain.models.Account;
import com.ms.movement.service.domain.models.Movement;
import com.ms.movement.service.domain.TypeMovementEnum;
import com.ms.movement.service.infraestructure.adapters.out.repository.AccountServiceClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MovementService implements MovementInPort {
    private final MovementOutPort movementOutPort;
    private final AccountServiceClient accountServiceClient;

    @Override
    public Movement createMovement(Movement movement) {
        Account account = accountServiceClient.getAccountById("dd", "dd", movement.getAccountId()).getBody();
        if (account == null) {
            throw new IllegalArgumentException("La cuenta no existe");
        }

        if (movement.getTypeMovement().equals(TypeMovementEnum.RETIRO)) {
            if (account.getAmount() > 0 && account.getAmount() >= movement.getAmount()) {
                double amount = account.getAmount() - movement.getAmount();
                account.setAmount(amount);
                accountServiceClient.updateAccount("", "", account.getId(), account);
                return movementOutPort.save(movement);
            } else {
                throw new IllegalArgumentException("No existe fondos suficientes en la cuenta.");
            }
        } else {
            double amount = account.getAmount() + movement.getAmount();
            account.setAmount(amount);
            accountServiceClient.updateAccount("", "", account.getId(), account);
            return movementOutPort.save(movement);
        }
    }

    @Override
    public List<Movement> getMovementsByAccount(Long accountId) {
        return movementOutPort.getMovementsByAccount(accountId);
    }
}
