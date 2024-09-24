package com.msf.customer.middleend.controller;

import com.msf.customer.middleend.domain.Customer;
import com.msf.customer.middleend.service.ICustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/customers")
@RequiredArgsConstructor
public class CustomerController {

    private final ICustomerService iCustomerService;

    @PostMapping()
    @CrossOrigin
    public ResponseEntity<Customer> createdCustomer(@RequestBody Customer customer) {
        return new ResponseEntity<>(iCustomerService.createdCustomer(customer), HttpStatus.CREATED);
    }
}
