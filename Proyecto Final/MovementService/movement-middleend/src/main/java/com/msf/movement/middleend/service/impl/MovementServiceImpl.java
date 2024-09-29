package com.msf.movement.middleend.service.impl;

import com.msf.movement.middleend.client.MovementServiceClient;
import com.msf.movement.middleend.domain.Movement;
import com.msf.movement.middleend.service.IMovementService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MovementServiceImpl implements IMovementService {
    private final MovementServiceClient movementServiceClient;

    @Override
    public Movement createMovement(String xSwClientRequestId, String xSwClientUserAgent, Movement movement) {
        return movementServiceClient.createMovement(xSwClientRequestId, xSwClientUserAgent, movement).getBody();
    }

    @Override
    public List<Movement> getMovementByAccount(String xSwClientRequestId, String xSwClientUserAgent, Long accountId) {
        return movementServiceClient.getMovementByAccount(xSwClientRequestId, xSwClientUserAgent, accountId).getBody();
    }
}
