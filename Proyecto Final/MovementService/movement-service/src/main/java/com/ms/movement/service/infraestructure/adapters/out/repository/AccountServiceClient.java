package com.ms.movement.service.infraestructure.adapters.out.repository;

import com.ms.movement.service.domain.models.Account;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.cloud.openfeign.FeignClient;

//@FeignClient(url = "http://localhost:8085/api/v1", name = "movement-service")
@FeignClient(name = "ACCOUNT-SERVICE")
public interface AccountServiceClient {
    @GetMapping("/api/v1/accounts/{id}")
    ResponseEntity<Account> getAccountById(@PathVariable("id") Long id,
                                           @RequestHeader(value = "x-sw-client-request-id", required = true) String xCmClientRequestId,
                                           @RequestHeader(value = "x-cm-client-user-agent", required = true) String xCmClientUserAgent);

    @PutMapping("/api/v1/accounts/{id}")
    ResponseEntity<Account> updateAccount(@RequestHeader(value = "x-sw-client-request-id", required = true) String xCmClientRequestId,
                                          @RequestHeader(value = "x-cm-client-user-agent", required = true) String xCmClientUserAgent,
                                          @PathVariable Long id, @RequestBody Account account);
}
