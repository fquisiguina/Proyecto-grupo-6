package com.msa.customer.service.infrastructure.adapters.in.rest;

import com.ms.customer.service.server.CustomersApi;
import com.ms.customer.service.server.models.CustomerDto;
import com.msa.customer.service.application.ports.in.CustomerIPort;
import com.msa.customer.service.domain.models.Customer;
import com.msa.customer.service.infrastructure.adapters.in.rest.mappers.CustomerDtoMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequiredArgsConstructor
public class CustomerController implements CustomersApi {

    private final CustomerIPort customerIPort;
    private final CustomerDtoMapper customerDtoMapper;

    @Override
    public ResponseEntity<CustomerDto> createCustomer(String xCmClientRequestId, String xCmClientUserAgent, CustomerDto customerDto) {
        Customer customer = customerDtoMapper.toCustomer(customerDto);

        CustomerDto customerSavedDto = customerDtoMapper.toCustomerDto(
                customerIPort.createCustomer(customer)
        );

        return new ResponseEntity<>(customerSavedDto, HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<CustomerDto> getCustomerById(Long id, String xCmClientRequestId, String xCmClientUserAgent) {
        Customer customer = customerIPort.getCustomerById(id);

        CustomerDto customerDto = customerDtoMapper.toCustomerDto(
                customerIPort.createCustomer(customer)
        );

        return new ResponseEntity<>(customerDto, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<CustomerDto> getCustomerByIdentification(String identification, String xCmClientRequestId, String xCmClientUserAgent) {
        Customer customer = customerIPort.getCustomerByIdentification(identification);

        CustomerDto customerDto = customerDtoMapper.toCustomerDto(
                customerIPort.createCustomer(customer)
        );

        return new ResponseEntity<>(customerDto, HttpStatus.OK);
    }
}
