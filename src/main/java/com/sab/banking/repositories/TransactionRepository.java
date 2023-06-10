package com.sab.banking.repositories;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.sab.banking.models.Transaction;
import com.sab.banking.models.TransactionType;

public interface TransactionRepository extends JpaRepository<Transaction, Integer> {

    List<Transaction> findAllByUserId(Integer userId);

    @Query("select sum(t.amount) from Transaction t where t.user.id = :userId")
    BigDecimal findAccountBalance(@Param("userId") Integer userId);

    @Query("select max(abs(t.amount))as amount from Transaction t where t.user.id = :userId and t.type = :transactionType")
    BigDecimal findHighestAmountByTransactionType(Integer userId, TransactionType transactionType);

    // @Query("select t.createdDate sum(t.amount) from Transaction t where t.user.id
    // = :userId and t.createdDate, between :start and :end group by t.createdDate")
    // Map<LocalDate, BigDecimal> findSumTransactionsByDate(LocalDateTime start,
    // LocalDateTime end, Integer userId);

}