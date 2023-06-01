package com.sab.banking.repositories;

import java.util.List;

import javax.transaction.Transaction;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<Transaction, Integer> {
    List<Transaction> findAllByAmount(String amount);

    List<Transaction> findAllByUserId(Integer userId);
}