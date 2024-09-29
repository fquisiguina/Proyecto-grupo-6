package com.msf.movement.middleend.client;

import com.msf.movement.middleend.domain.Movement;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(url = "http://localhost:8086/api/v1", name = "movement-service")
public interface MovementServiceClient {
    @PostMapping("/movements")
    ResponseEntity<Movement> createMovement(@RequestHeader(value = "x-sw-client-request-id", required = true) String xSwClientRequestId, @RequestHeader(value = "x-sw-client-user-agent", required = true) String xSwClientUserAgent, @RequestBody Movement movement);

    @GetMapping("/movements/accounts/{accountId}")
    ResponseEntity<List<Movement>> getMovementByAccount(@RequestHeader(value = "x-sw-client-request-id", required = true) String xSwClientRequestId, @RequestHeader(value = "x-sw-client-user-agent", required = true) String xSwClientUserAgent, @PathVariable Long accountId);
}
