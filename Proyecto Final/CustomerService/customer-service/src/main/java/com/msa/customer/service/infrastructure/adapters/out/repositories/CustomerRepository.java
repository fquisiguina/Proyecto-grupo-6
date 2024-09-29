package com.msa.customer.service.infrastructure.adapters.out.repositories;

import com.msa.customer.service.domain.models.Customer;
import com.msa.customer.service.infrastructure.adapters.out.entities.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<CustomerEntity, Integer> {
    CustomerEntity findByIdentification(String identification);
}
