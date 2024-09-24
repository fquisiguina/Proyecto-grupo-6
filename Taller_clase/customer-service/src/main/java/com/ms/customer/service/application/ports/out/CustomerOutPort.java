package com.ms.customer.service.application.ports.out;


import com.ms.customer.service.domain.models.Customer;

public interface CustomerOutPort {

    Customer save(Customer customer);

}
