package com.brxnorafa.fraud_detection_engine.transaction.service;

public class TransactionNotFoundException extends RuntimeException {
    public TransactionNotFoundException(Long id) {
        super("Transaction not found: " + id);
    }
}
