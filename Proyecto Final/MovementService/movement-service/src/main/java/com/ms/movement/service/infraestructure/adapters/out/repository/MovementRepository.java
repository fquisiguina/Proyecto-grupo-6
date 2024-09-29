package com.ms.movement.service.infraestructure.adapters.out.repository;

import com.ms.movement.service.infraestructure.adapters.out.entity.MovementEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MovementRepository extends JpaRepository<MovementEntity, Long> {
    @Query(value = "SELECT m FROM  MovementEntity m WHERE m.accountId=?1", nativeQuery = true)
    List<MovementEntity> findByMovementsByAccountId(Long accountId);
}
