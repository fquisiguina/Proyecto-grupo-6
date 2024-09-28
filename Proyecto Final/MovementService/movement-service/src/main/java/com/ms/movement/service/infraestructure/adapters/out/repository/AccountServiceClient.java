package com.ms.movement.service.infraestructure.adapters.out.repository;

import com.ms.movement.service.domain.models.Account;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name = "movement--service")
public interface AccountServiceClient {
    @GetMapping("/api/v1/account/{id}")
    ResponseEntity<Account> getAccountById(@RequestHeader(value = "x-cm-client-request-id", required = true) String xCmClientRequestId,
                                           @RequestHeader(value = "x-cm-client-user-agent", required = true) String xCmClientUserAgent,
                                           @PathVariable Long id);

    @PutMapping("/api/v1/account/{id}")
    ResponseEntity<Account> updateAccount(@RequestHeader(value = "x-cm-client-request-id", required = true) String xCmClientRequestId,
                                          @RequestHeader(value = "x-cm-client-user-agent", required = true) String xCmClientUserAgent,
                                          @PathVariable Long id, @RequestBody Account account);
}
