package com.ms.movement.service.application.ports.in;

import com.ms.movement.service.domain.models.Account;
import com.ms.movement.service.domain.models.Movement;

public interface AccountInPort {
    Account getAccount(String xSwClientRequestId, String xSwClientUserAgent, Long accountId);

    Account processTransaction(String xSwClientRequestId, String xSwClientUserAgent, Account accountIn, Movement movement);
}
