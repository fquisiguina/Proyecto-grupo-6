package com.ms.customer.service.application.ports.in;

import com.ms.customer.service.domain.models.Customer;

public interface CustomerInPort {
    Customer saveCustomer(Customer customer);
}
