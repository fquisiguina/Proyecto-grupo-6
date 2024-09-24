package com.ms.customer.service.infraestructure.adapter.in.rest;

import com.ms.customer.service.application.ports.in.CustomerInPort;
import com.ms.customer.service.infraestructure.adapter.in.rest.mapper.CustomerDomainMapper;
import com.ms.customer.service.server.CustomersApi;
import com.ms.customer.service.server.models.Customer;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class CustomerController implements CustomersApi  {

    private final CustomerInPort customerInPort;
    private final CustomerDomainMapper customerDomainMapper;

    //private String nombre;
    @Override
    @CrossOrigin
    public ResponseEntity<Customer> createCustomer(String xCmClientRequestId, String xCmClientUserAgent, Customer customer) {
        //customerInPort.saveCustomer(customerDomainMapper.toCustomerDomain(customer));
        //return CustomersApi.super.createCustomer(xCmClientRequestId, xCmClientUserAgent, customer);
        //nombre.toLowerCase();

        return new ResponseEntity<>(customerDomainMapper.toCustomer(customerInPort.saveCustomer(customerDomainMapper.toCustomerDomain(customer))), HttpStatus.CREATED);
    }
}
