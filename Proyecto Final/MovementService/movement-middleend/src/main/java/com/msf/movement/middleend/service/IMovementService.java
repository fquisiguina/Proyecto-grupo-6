package com.msf.movement.middleend.service;

import com.msf.movement.middleend.domain.Movement;

import java.util.List;

public interface IMovementService {
    Movement createMovement(String xSwClientRequestId, String xSwClientUserAgent, Movement movement);

    List<Movement> getMovementByAccount(String xSwClientRequestId, String xSwClientUserAgent, Long accountId);
}
