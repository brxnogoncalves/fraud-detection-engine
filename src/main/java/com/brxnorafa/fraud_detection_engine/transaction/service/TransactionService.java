package com.brxnorafa.fraud_detection_engine.transaction.service;

import com.brxnorafa.fraud_detection_engine.transaction.dto.CreateTransactionRequest;
import com.brxnorafa.fraud_detection_engine.transaction.dto.TransactionResponse;
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

    public TransactionResponse create(CreateTransactionRequest transaction) {
        Transaction transactionToSave = new Transaction(
                transaction.amount(),
                transaction.currency(),
                transaction.customerId(),
                transaction.timestamp(),
                Transaction.Status.PENDING
        );

        Transaction saved = transactionRepository.save(transactionToSave);

        return new TransactionResponse(
                saved.getId(),
                saved.getAmount(),
                saved.getCurrency(),
                saved.getCustomerId(),
                saved.getTimestamp(),
                saved.getStatus()
        );
    }

    public List<TransactionResponse> findAll() {
        List<TransactionResponse> transactions = transactionRepository.findAll().stream()
                .map(transaction -> new TransactionResponse(
                        transaction.getId(),
                        transaction.getAmount(),
                        transaction.getCurrency(),
                        transaction.getCustomerId(),
                        transaction.getTimestamp(),
                        transaction.getStatus()
                ))
                .toList();

        return transactions;
    }

    public TransactionResponse findById(Long id) {
        Transaction transaction = transactionRepository.findById(id)
                .orElseThrow(() -> new TransactionNotFoundException(id));

        return new TransactionResponse(
                transaction.getId(),
                transaction.getAmount(),
                transaction.getCurrency(),
                transaction.getCustomerId(),
                transaction.getTimestamp(),
                transaction.getStatus()
        );
    }

    public void delete(Long id) {
        Transaction transactionToDelete = transactionRepository.findById(id)
                .orElseThrow(() -> new TransactionNotFoundException(id));

        transactionRepository.delete(transactionToDelete);
    }

    public TransactionResponse updateStatus(Long id, Transaction.Status status) {
        Transaction transaction = transactionRepository.findById(id)
                .orElseThrow(() -> new TransactionNotFoundException(id));

        transaction.setStatus(status);

        transactionRepository.save(transaction);

        return new TransactionResponse(
                transaction.getId(),
                transaction.getAmount(),
                transaction.getCurrency(),
                transaction.getCustomerId(),
                transaction.getTimestamp(),
                transaction.getStatus()
        );
    }
}
