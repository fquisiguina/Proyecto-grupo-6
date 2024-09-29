package com.msa.customer.service.application.ports.out;

import com.msa.customer.service.domain.models.Customer;

public interface CustomerOPort {

    Customer save(Customer customer);

    Customer getCustomerById(long id);

    Customer getCustomerByIdentification(String identification);
}
