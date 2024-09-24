package com.ms.customer.service.infraestructure.adapter.out.customers.repository.mappers;


import com.ms.customer.service.domain.models.Customer;
import com.ms.customer.service.infraestructure.adapter.out.customers.entity.CustomerEntity;
import org.mapstruct.Mapper;


@Mapper(componentModel = "spring")
public interface CustomerMapper {

    CustomerEntity toCustomerEntity(Customer customer);

    Customer toCustomer(CustomerEntity customerEntity);
}
