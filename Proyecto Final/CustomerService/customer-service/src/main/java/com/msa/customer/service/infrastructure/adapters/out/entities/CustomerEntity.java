package com.msa.customer.service.infrastructure.adapters.out.entities;

import com.msa.customer.service.infrastructure.adapters.out.enums.GenreEnumEntity;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "cus_customer_tbl", schema = "customer")
public class CustomerEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ctr_id", nullable = false)
    private Integer id;

    @Column(name = "ctr_dni", nullable = false, unique = true)
    private String identification;

    @Column(name = "ctr_f_name", nullable = false)
    private String firstName;

    @Column(name = "ctr_l_name", nullable = false)
    private String lastName;

    @Enumerated(EnumType.STRING)
    @Column(name = "ctr_genre", nullable = false)
    private GenreEnumEntity genre;
}
