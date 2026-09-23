package com.brxnorafa.fraud_detection_engine.transaction.service;

import com.brxnorafa.fraud_detection_engine.transaction.entity.Transaction;
import com.brxnorafa.fraud_detection_engine.transaction.repository.TransactionRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionService {
    private final TransactionRepository transactionRepository;

    public TransactionService(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    public Transaction create(Transaction transaction) {
        return transactionRepository.save(transaction);
    }

    public List<Transaction> findAll() {
        return transactionRepository.findAll();
    }

    public Transaction findById(Long id) {
        return transactionRepository.findById(id)
                .orElseThrow(() -> new TransactionNotFoundException(id));
    }

    public void delete(Long id) {
        transactionRepository.deleteById(id);
    }
}
