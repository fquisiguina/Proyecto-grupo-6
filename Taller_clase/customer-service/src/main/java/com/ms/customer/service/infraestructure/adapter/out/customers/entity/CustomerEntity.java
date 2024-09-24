package com.ms.customer.service.infraestructure.adapter.out.customers.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "T_CUSTOMERS")
@Data
public class CustomerEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CUS_ID")
    private Integer id;

    @Column(name = "CUS_IDENTIFICATION")
    private String identification;

    @Column(name = "CUS_FIRST_NAME")
    private String firstName;

    @Column(name = "CUS_LAST_NAME")
    private String lastName;

    @Column(name = "CUS_GENRE")
    private String genre;



}
