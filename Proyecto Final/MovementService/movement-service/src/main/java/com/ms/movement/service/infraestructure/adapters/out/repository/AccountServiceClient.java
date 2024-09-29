package com.ms.movement.service.infraestructure.adapters.out.repository;

import com.ms.movement.service.domain.models.Account;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(url = "https://localhost:8090/api/v1", name = "movement-service")
public interface AccountServiceClient {
    @GetMapping("/account/{id}")
    ResponseEntity<Account> getAccountById(@RequestHeader(value = "x-cm-client-request-id", required = true) String xCmClientRequestId,
                                           @RequestHeader(value = "x-cm-client-user-agent", required = true) String xCmClientUserAgent,
                                           @PathVariable Long id);

    @PutMapping("/account/{id}")
    ResponseEntity<Account> updateAccount(@RequestHeader(value = "x-cm-client-request-id", required = true) String xCmClientRequestId,
                                          @RequestHeader(value = "x-cm-client-user-agent", required = true) String xCmClientUserAgent,
                                          @PathVariable Long id, @RequestBody Account account);
}
