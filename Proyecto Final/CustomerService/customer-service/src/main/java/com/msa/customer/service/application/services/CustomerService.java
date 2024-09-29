package com.msa.customer.service.application.services;

import com.msa.customer.service.application.ports.in.CustomerIPort;
import com.msa.customer.service.application.ports.out.CustomerOPort;
import com.msa.customer.service.domain.models.Customer;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomerService implements CustomerIPort {

    private final CustomerOPort customerOPort;

    @Override
    public Customer createCustomer(Customer customer) {
        return customerOPort.save(customer);
    }

    @Override
    public Customer getCustomerById(long id) {
        return customerOPort.getCustomerById(id);
    }

    @Override
    public Customer getCustomerByIdentification(String identification) {
        return customerOPort.getCustomerByIdentification(identification);
    }

}
