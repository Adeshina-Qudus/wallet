package com.semicolon.wallet.data.models;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Setter
@Getter
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String userId;
    private BigDecimal amount;
    private String description;
    private Status status = Status.PROCESSING;
    private LocalDateTime createdAt;
    @ManyToOne
    private Wallet wallet;
}
