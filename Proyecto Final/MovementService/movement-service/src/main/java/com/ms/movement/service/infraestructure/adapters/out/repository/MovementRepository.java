package com.ms.movement.service.infraestructure.adapters.out.repository;

import com.ms.movement.service.infraestructure.adapters.out.entity.MovementEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovementRepository extends JpaRepository<MovementEntity, Long> {
}
