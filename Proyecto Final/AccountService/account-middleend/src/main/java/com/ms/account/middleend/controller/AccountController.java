package com.ms.account.middleend.controller;

import com.ms.account.middleend.domain.Account;
import com.ms.account.middleend.domain.Movement;
import com.ms.account.middleend.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class AccountController {

    private final AccountService accountService;

    @PostMapping("/accounts")
    @CrossOrigin
    public ResponseEntity<Account> createdCustomer(@RequestHeader(value = "x-sw-client-request-id", required = true) String xSwClientRequestId,
                                                   @RequestHeader(value = "x-cm-client-user-agent", required = true) String xCmClientUserAgent,
                                                   @RequestBody Account account) {
        return new ResponseEntity<>(accountService.createAccount(xSwClientRequestId, xCmClientUserAgent, account), HttpStatus.CREATED);
    }

    @GetMapping("/accounts/{id}")
    @CrossOrigin
    ResponseEntity<Account> getAccountById(@PathVariable("id") Long id,
                                           @RequestHeader(value = "x-sw-client-request-id", required = true) String xSwClientRequestId,
                                           @RequestHeader(value = "x-cm-client-user-agent", required = true) String xCmClientUserAgent){
        return new ResponseEntity<>(accountService.getAccountById(id, xSwClientRequestId, xCmClientUserAgent), HttpStatus.OK);
    }

    @GetMapping("/accounts/customer/{id}")
    @CrossOrigin
    ResponseEntity<List<Account>> getAccountsByCustomerId(@PathVariable("id") Long id,
                                                          @RequestHeader(value = "x-sw-client-request-id", required = true) String xSwClientRequestId,
                                                          @RequestHeader(value = "x-cm-client-user-agent", required = true) String xCmClientUserAgent){
        return new ResponseEntity<>(accountService.getAccountsByCustomerId(id, xSwClientRequestId, xCmClientUserAgent), HttpStatus.OK);
    }

    @PutMapping("/accounts/{id}")
    @CrossOrigin
    ResponseEntity<Account> updateAccountMovement(@PathVariable("id") Long id,
                                                  @RequestHeader(value = "x-sw-client-request-id", required = true) String xSwClientRequestId,
                                                  @RequestHeader(value = "x-cm-client-user-agent", required = true) String xCmClientUserAgent,
                                                  @RequestBody Movement movement){
        return new ResponseEntity<>(accountService.updateAccountMovement(id, xSwClientRequestId, xCmClientUserAgent, movement), HttpStatus.OK);

    }

}
