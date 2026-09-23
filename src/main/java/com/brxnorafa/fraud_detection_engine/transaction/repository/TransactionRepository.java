package com.brxnorafa.fraud_detection_engine.transaction.repository;

import com.brxnorafa.fraud_detection_engine.transaction.entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {
}
