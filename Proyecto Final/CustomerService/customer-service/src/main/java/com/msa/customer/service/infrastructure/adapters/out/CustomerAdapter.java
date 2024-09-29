package com.msa.customer.service.infrastructure.adapters.out;

import com.msa.customer.service.application.ports.out.CustomerOPort;
import com.msa.customer.service.domain.exceptions.CustomerNotFoundException;
import com.msa.customer.service.domain.models.Customer;
import com.msa.customer.service.infrastructure.adapters.out.entities.CustomerEntity;
import com.msa.customer.service.infrastructure.adapters.out.mappers.CustomerEntityMapper;
import com.msa.customer.service.infrastructure.adapters.out.repositories.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.security.auth.login.AccountNotFoundException;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class CustomerAdapter implements CustomerOPort {

    private final CustomerRepository customerRepository;
    private final CustomerEntityMapper customerEntityMapper;

    @Override
    public Customer save(Customer customer) {
        CustomerEntity customerEntity = customerEntityMapper.toCustomerEntity(customer);
        Customer customerSaved = customerEntityMapper.toCustomer(
                customerRepository.save(customerEntity)
        );
        return customerSaved;
    }

    @Override
    public Customer getCustomerById(long id) {

        Optional<CustomerEntity> customer = customerRepository.findById((int)id);

        if (customer.isPresent()) {
            CustomerEntity customerEntity = customer.get();
            return  customerEntityMapper.toCustomer(customerEntity);

        } else {
            throw new CustomerNotFoundException("Customer not found");
        }
    }

    @Override
    public Customer getCustomerByIdentification(String identification) {

        CustomerEntity customer = customerRepository.findByIdentification(identification);

        if (customer != null) {
            return  customerEntityMapper.toCustomer(customer);
        } else {
            throw new CustomerNotFoundException("Customer not found");
        }
    }

}
