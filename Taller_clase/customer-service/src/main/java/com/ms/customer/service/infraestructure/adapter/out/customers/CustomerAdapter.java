package com.ms.customer.service.infraestructure.adapter.out.customers;

import com.ms.customer.service.application.ports.out.CustomerOutPort;
import com.ms.customer.service.domain.models.Customer;
import com.ms.customer.service.infraestructure.adapter.out.customers.entity.CustomerEntity;
import com.ms.customer.service.infraestructure.adapter.out.customers.repository.CustomerRepository;
import com.ms.customer.service.infraestructure.adapter.out.customers.repository.mappers.CustomerMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CustomerAdapter  implements CustomerOutPort  {


    private final CustomerRepository customerRepository;
    private final CustomerMapper customerMapper;

    @Override
    public Customer save(Customer customer) {
        CustomerEntity custormerEntity = customerMapper.toCustomerEntity(customer);

        return customerMapper.toCustomer(customerRepository.save(custormerEntity));
    }

}
