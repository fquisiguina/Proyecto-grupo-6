package com.msf.customer.middleend.service.impl;

import com.msf.customer.middleend.client.CustomerServiceClient;
import com.msf.customer.middleend.domain.Customer;
import com.msf.customer.middleend.service.ICustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements ICustomerService {

    private final CustomerServiceClient customerServiceClient;

    @Override
    public Customer createdCustomer(Customer customer) {
        return customerServiceClient
                .createCustomer("wer","wer",customer).getBody();
    }
}
