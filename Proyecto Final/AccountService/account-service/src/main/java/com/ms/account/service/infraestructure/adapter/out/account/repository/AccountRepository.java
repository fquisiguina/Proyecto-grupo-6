package com.ms.account.service.infraestructure.adapter.out.account.repository;

import com.ms.account.service.infraestructure.adapter.out.account.entity.AccountEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AccountRepository extends JpaRepository<AccountEntity, Long> {

    // Consulta personalizada con JPQL
    @Query("SELECT a FROM AccountEntity a WHERE a.customerId = :customerId")
    List<AccountEntity> findAccountsByCustomerId(@Param("customerId") Long customerId);

}
