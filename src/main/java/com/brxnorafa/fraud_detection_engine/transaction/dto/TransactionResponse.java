package com.brxnorafa.fraud_detection_engine.transaction.dto;

import com.brxnorafa.fraud_detection_engine.transaction.entity.Transaction;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record TransactionResponse(
        Long id,
        BigDecimal amount,
        String currency,
        String customerId,
        LocalDateTime timestamp,
        Transaction.Status status
) {
}
