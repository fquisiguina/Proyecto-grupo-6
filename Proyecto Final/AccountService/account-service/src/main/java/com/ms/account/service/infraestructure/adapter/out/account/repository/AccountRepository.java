package com.ms.account.service.infraestructure.adapter.out.account.repository;

import com.ms.account.service.infraestructure.adapter.out.account.entity.AccountEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<AccountEntity, Long> {

}
