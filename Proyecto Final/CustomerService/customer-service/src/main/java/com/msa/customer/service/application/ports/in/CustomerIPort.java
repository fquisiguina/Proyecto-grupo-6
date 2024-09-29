package com.msa.customer.service.application.ports.in;

import com.msa.customer.service.domain.models.Customer;

public interface CustomerIPort {

    Customer createCustomer(Customer customer);

    Customer getCustomerById(long id);

    Customer getCustomerByIdentification(String identification);

}
