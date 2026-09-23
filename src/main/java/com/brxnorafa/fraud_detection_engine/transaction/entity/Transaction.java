package com.brxnorafa.fraud_detection_engine.transaction.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "transactions")
@Getter
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Setter
    @Column(nullable = false, precision = 19, scale = 2)
    private BigDecimal amount;

    @Setter
    @Column(nullable = false, length = 3)
    private String currency;

    @Setter
    @Column(name = "customer_id", nullable = false)
    private String customerId;

    @Setter
    @Column(nullable = false)
    private LocalDateTime timestamp;

    @Setter
    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 20)
    private Status status;


    public enum Status {
        PENDING,
        APPROVED,
        REJECTED
    }

    public Transaction() {}

    public Transaction(
            BigDecimal amount,
            String currency,
            String customerId,
            LocalDateTime timestamp,
            Status status
    ) {
        this.amount = amount;
        this.currency = currency;
        this.customerId = customerId;
        this.timestamp = timestamp;
        this.status = status;
    }

}


