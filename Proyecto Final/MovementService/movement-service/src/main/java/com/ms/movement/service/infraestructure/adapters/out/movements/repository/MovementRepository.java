package com.ms.movement.service.infraestructure.adapters.out.movements.repository;

import com.ms.movement.service.infraestructure.adapters.out.movements.entity.MovementEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovementRepository extends JpaRepository<MovementEntity, Long> {
}
