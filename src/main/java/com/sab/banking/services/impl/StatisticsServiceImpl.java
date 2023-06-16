package com.sab.banking.services.impl;

import java.math.BigDecimal;

import org.springframework.stereotype.Service;

import com.sab.banking.models.TransactionType;
import com.sab.banking.repositories.TransactionRepository;
import com.sab.banking.services.StatisticsService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class StatisticsServiceImpl implements StatisticsService {

    private final TransactionRepository transactionRepository;

    // @Override
    // public Map<LocalDate, BigDecimal> findSumTransactionsByDate(LocalDate
    // startDate, LocalDate endDate,
    // Integer userId) {
    // LocalDateTime start = LocalDateTime.of(startDate, LocalTime.of(0, 0, 0));
    // LocalDateTime end = LocalDateTime.of(endDate, LocalTime.of(23, 59, 59));
    // return transactionRepository.findSumTransactionsByDate(start, end, userId);
    // }

    @Override
    public BigDecimal getAccountBalance(Integer userId) {
        return transactionRepository.findAccountBalance(userId);
    }

    @Override
    public BigDecimal highestDeposit(Integer userId) {

        return transactionRepository.findHighestAmountByTransactionType(userId, TransactionType.TRANSFERT);
    }

    @Override
    public BigDecimal highestTransfer(Integer userId) {
        return transactionRepository.findHighestAmountByTransactionType(userId, TransactionType.DEPOSIT);
    }

}