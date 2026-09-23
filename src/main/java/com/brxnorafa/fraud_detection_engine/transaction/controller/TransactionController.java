package com.brxnorafa.fraud_detection_engine.transaction.controller;

import com.brxnorafa.fraud_detection_engine.transaction.dto.CreateTransactionRequest;
import com.brxnorafa.fraud_detection_engine.transaction.entity.Transaction;
import com.brxnorafa.fraud_detection_engine.transaction.service.TransactionService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/transactions")
public class TransactionController {
    private final TransactionService transactionService;

    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @PostMapping
    public ResponseEntity<Transaction> create(@Valid @RequestBody CreateTransactionRequest transaction) {
        return ResponseEntity.ok(transactionService.create(transaction));
    }

    @GetMapping
    public ResponseEntity<List<Transaction>> findAll() {
        return ResponseEntity.ok(transactionService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Transaction> findById(@PathVariable Long id) {
        return ResponseEntity.ok(transactionService.findById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        transactionService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PatchMapping("/{id}/status")
    public ResponseEntity<Transaction> updateStatus(
            @PathVariable Long id,
            @RequestParam Transaction.Status status
    ) {
        return ResponseEntity.ok(transactionService.updateStatus(id, status));
    }
}
