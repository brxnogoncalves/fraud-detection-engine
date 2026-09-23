package com.brxnorafa.fraud_detection_engine.transaction.service;

import com.brxnorafa.fraud_detection_engine.transaction.entity.Transaction;

public class InvalidTransactionStatusUpdateException extends RuntimeException {
    public InvalidTransactionStatusUpdateException(Transaction.Status oldStatus, Transaction.Status newStatus) {
        super(buildMessage(oldStatus, newStatus));
    }

    private static String buildMessage(Transaction.Status oldStatus, Transaction.Status newStatus) {
        if (!oldStatus.equals(Transaction.Status.PENDING)) {
            return "Cannot change transaction status from " + oldStatus + " to " + newStatus;
        }
        if (newStatus.equals(Transaction.Status.PENDING)) {
            return "Cannot change transaction status from PENDING to PENDING";
        }
        return "Invalid transaction status update from " + oldStatus + " to " + newStatus;
    }
}
