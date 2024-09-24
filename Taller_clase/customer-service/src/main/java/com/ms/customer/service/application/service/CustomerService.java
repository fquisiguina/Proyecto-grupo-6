package com.ms.customer.service.application.service;

import com.ms.customer.service.application.ports.in.CustomerInPort;
import com.ms.customer.service.application.ports.out.CustomerOutPort;
import com.ms.customer.service.domain.models.Customer;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomerService implements CustomerInPort {

    private final CustomerOutPort customerOutPort;

    @Override
    public Customer saveCustomer(Customer customer) {
        return customerOutPort.save(customer);
    }
}
