package com.ms.account.service.infraestructure.adapter.out.account.repository;

import com.ms.account.service.domain.models.Customer;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;

//@FeignClient(url = "http://localhost:8084/api/v1", name = "customerServiceClient")
@FeignClient(name = "CUSTOMER-SERVICE")
public interface CustomerServiceClient {

    //@GetMapping("/customers/{id}")
    @GetMapping("/api/v1/customers/{id}")
    ResponseEntity<Customer> getCustomerById(@PathVariable("id") Long id,
                                            @RequestHeader(value = "x-cm-client-request-id", required = true) String xCwClientRequestId,
                                            @RequestHeader(value = "x-cm-client-user-agent", required = true) String xCmClientUserAgent);
}
