package com.ms.movement.service.infraestructure.adapters.in.res;

import com.ms.movement.service.application.ports.in.MovementInPort;
import com.ms.movement.service.infraestructure.adapters.in.res.mappers.MovementDomainMapper;
import com.ms.movement.service.server.MovementsApi;
import com.ms.movement.service.server.models.Movement;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class MovementController implements MovementsApi {
    private final MovementInPort movementInPort;
    private final MovementDomainMapper movementDomainMapper;
    @CrossOrigin
    @Override
    public ResponseEntity<Movement> createMovement(String xSwClientRequestId, String xSwClientUserAgent, Movement movement) {
        com.ms.movement.service.domain.models.Movement movementIn = movementDomainMapper.toMovementDomain(movement);
        com.ms.movement.service.domain.models.Movement movementOut = movementInPort.createMovement(movementIn);

        return new ResponseEntity<Movement>(movementDomainMapper.toMovement(movementOut), HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<List<Movement>> getMovementByAccount(String accountId, String xSwClientRequestId, String xSwClientUserAgent) {
        return MovementsApi.super.getMovementByAccount(accountId, xSwClientRequestId, xSwClientUserAgent);
    }
}
