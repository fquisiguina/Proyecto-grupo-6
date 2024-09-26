package com.ms.movement.service.infraestructure.adapters.out.movements.entity;

import com.ms.movement.service.server.models.Movement;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "mov_movement_tbl")
@Data
public class MovementEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "mov_id")
    private Long id;
    @Column(name = "mov_type_movement")
    private Movement.TypeMovementEnum typeMovement;
    @Column(name = "mov_amount")
    private Double amount;
    @Column(name = "mov_account_id")
    private Long accountId;
}
