package com.msf.movement.middleend.controller;

import com.msf.movement.middleend.domain.Movement;
import com.msf.movement.middleend.service.IMovementService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/movements")
@RequiredArgsConstructor
public class MovementController {
    private final IMovementService iMovementService;

    @PostMapping
    @CrossOrigin
    public ResponseEntity<Movement> createMovement(@RequestHeader(value = "x-sw-client-request-id", required = true) String xSwClientRequestId, @RequestHeader(value = "x-sw-client-user-agent", required = true) String xSwClientUserAgent, @RequestBody Movement movement) {
        return new ResponseEntity<>(iMovementService.createMovement(xSwClientRequestId, xSwClientUserAgent, movement), HttpStatus.CREATED);
    }

    @GetMapping("/accounts/{accountId}")
    public ResponseEntity<List<Movement>> getMovementByAccount(@RequestHeader(value = "x-sw-client-request-id", required = true) String xSwClientRequestId, @RequestHeader(value = "x-sw-client-user-agent", required = true) String xSwClientUserAgent, @PathVariable Integer accountId) {
        return new ResponseEntity<>(iMovementService.getMovementByAccount(xSwClientRequestId, xSwClientUserAgent, Long.valueOf(accountId)), HttpStatus.OK);
    }
}
