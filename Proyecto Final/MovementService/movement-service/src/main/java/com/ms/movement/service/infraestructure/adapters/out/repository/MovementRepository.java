package com.ms.movement.service.infraestructure.adapters.out.repository;

import com.ms.movement.service.infraestructure.adapters.out.entity.MovementEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MovementRepository extends JpaRepository<MovementEntity, Long> {
    @Query(value = "SELECT mov FROM  MovementEntity mov WHERE mov.accountId=:accountId")
    List<MovementEntity> findByMovementsByAccountId(Long accountId);
}
