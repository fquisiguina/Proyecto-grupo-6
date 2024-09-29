package com.ms.account.middleend.client;

import com.ms.account.middleend.domain.Account;
import com.ms.account.middleend.domain.Movement;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@FeignClient(url = "http://localhost:8085/api/v1", name = "accountServiceClient")
@FeignClient(name = "ACCOUNT-SERVICE")
public interface AccountServiceClient {

    //@PostMapping("/accounts")
    @PostMapping("/api/v1/accounts")
    ResponseEntity<Account> createAccount(@RequestHeader(value = "x-sw-client-request-id", required = true) String xSwClientRequestId,
                                          @RequestHeader(value = "x-cm-client-user-agent", required = true) String xCmClientUserAgent,
                                          @RequestBody Account account);

    //@GetMapping("/accounts/{id}")
    @GetMapping("/api/v1/accounts/{id}")
    ResponseEntity<Account> getAccountById(@PathVariable("id") Long id,
                                           @RequestHeader(value = "x-sw-client-request-id", required = true) String xSwClientRequestId,
                                           @RequestHeader(value = "x-cm-client-user-agent", required = true) String xCmClientUserAgent);

    //@GetMapping("/accounts/customer/{id}")
    @GetMapping("/api/v1/accounts/customer/{id}")
    ResponseEntity<List<Account>> getAccountsByCustomerId(@PathVariable("id") Long id,
                                                          @RequestHeader(value = "x-sw-client-request-id", required = true) String xSwClientRequestId,
                                                          @RequestHeader(value = "x-cm-client-user-agent", required = true) String xCmClientUserAgent);
    //@PutMapping("/accounts/{id}")
    @PutMapping("/api/v1/accounts/{id}")
    ResponseEntity<Account> updateAccountMovement(@PathVariable("id") Long id,
                                                  @RequestHeader(value = "x-sw-client-request-id", required = true) String xSwClientRequestId,
                                                  @RequestHeader(value = "x-cm-client-user-agent", required = true) String xCmClientUserAgent,
                                                  @RequestBody Movement movement);
}
