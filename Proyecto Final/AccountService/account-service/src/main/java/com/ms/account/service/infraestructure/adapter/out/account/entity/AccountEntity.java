package com.ms.account.service.infraestructure.adapter.out.account.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.OffsetDateTime;
import java.util.Date;

@Entity
@Table(name = "acc_account_tbl", schema = "account")
@Data
public class AccountEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "acc_id_account")
    private Long id;

    @Column(name = "acc_number_account", length = 10)
    private String numberAccount;

    @Column(name = "acc_currency_type", length = 3)
    private String currencyType;

    @Column(name = "acc_amount")
    private Double amount;

    @Column(name = "acc_custormer_id")
    private Long customerId;

    @Column(name = "acc_user_creates")
    private String userCreates;

    @Column(name = "acc_user_modifies")
    private String userModifies;

    @Column(name = "acc_date_creates")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateCreate;

    @Column(name = "acc_date_modifies")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateModifies;

    @Column(name = "acc_status")
    private boolean status;
}
