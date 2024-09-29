package com.msa.customer.service.infrastructure.adapters.out.mappers;

import com.msa.customer.service.domain.models.Customer;
import com.msa.customer.service.infrastructure.adapters.out.entities.CustomerEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CustomerEntityMapper {

    CustomerEntity toCustomerEntity(Customer customer);
    Customer toCustomer(CustomerEntity customer);
}
