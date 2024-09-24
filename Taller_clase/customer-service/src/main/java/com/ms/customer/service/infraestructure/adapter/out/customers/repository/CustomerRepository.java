package com.ms.customer.service.infraestructure.adapter.out.customers.repository;

import com.ms.customer.service.infraestructure.adapter.out.customers.entity.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<CustomerEntity, Integer> {

}
