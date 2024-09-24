package com.ms.customer.service.infraestructure.adapter.in.rest.mapper;

import com.ms.customer.service.server.models.Customer;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CustomerDomainMapper {

    com.ms.customer.service.domain.models.Customer toCustomerDomain(Customer customer);
    Customer toCustomer(com.ms.customer.service.domain.models.Customer customer);
}
