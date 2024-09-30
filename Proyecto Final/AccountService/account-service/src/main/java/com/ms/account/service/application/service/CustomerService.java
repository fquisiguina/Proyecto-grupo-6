package com.ms.account.service.application.service;

import com.ms.account.service.application.ports.in.CustomerInPort;
import com.ms.account.service.infraestructure.adapter.out.account.repository.CustomerServiceClient;
import com.ms.account.service.domain.models.Customer;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class CustomerService implements CustomerInPort {

    private final CustomerServiceClient customerServiceClient;

    @Override
    public Customer getCustomerById(Long id, String xCmClientRequestId, String xCmClientUserAgent) {
        ResponseEntity<Customer> accountResponse = customerServiceClient.getCustomerById(id, xCmClientRequestId, xCmClientUserAgent);

        if (accountResponse.getStatusCode().equals(HttpStatus.NO_CONTENT)) {
            throw new RuntimeException("Error, Cliente no registrado " + id);
        }

        return accountResponse.getBody();
        //return customerServiceClient.getCustomerById(id, xCmClientRequestId, xCmClientRequestId).getBody();
    }
}
