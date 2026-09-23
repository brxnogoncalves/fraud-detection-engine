package com.brxnorafa.fraud_detection_engine.transaction.dto;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record CreateTransactionRequest(
        @NotNull
        @DecimalMin(value = "0.01")
        BigDecimal amount,

        @NotBlank
        String currency,

        @NotBlank
        String customerId,

        @NotNull
        LocalDateTime timestamp
) {
}
