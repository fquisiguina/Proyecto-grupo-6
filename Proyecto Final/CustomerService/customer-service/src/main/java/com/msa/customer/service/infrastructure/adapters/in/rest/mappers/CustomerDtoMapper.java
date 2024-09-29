package com.msa.customer.service.infrastructure.adapters.in.rest.mappers;

import com.ms.customer.service.server.models.CustomerDto;
import com.msa.customer.service.domain.models.Customer;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CustomerDtoMapper {

    CustomerDto toCustomerDto(Customer customer);
    Customer toCustomer(CustomerDto customerDto);
}
