package com.ms.movement.service.infraestructure.adapters.out.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Table(name = "mov_movement_tbl")
@Data
public class MovementEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "mov_id", nullable = false)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(name = "mov_type_movement", nullable = false)
    private TypeMovementEnumEntity typeMovement;

    @Column(name = "mov_amount", nullable = false)
    private Double amount;

    @Column(name = "mov_account_id", nullable = false)
    private Long accountId;

    @Column(name = "mov_user_creates")
    private String userCreates;

    @Column(name = "mov_user_modifies")
    private String userModifies;

    @Column(name = "mov_date_creates")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateCreate;

    @Column(name = "mov_date_modifies")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateModifies;
}
