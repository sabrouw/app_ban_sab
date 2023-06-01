package com.sab.banking.services;

import java.util.List;

import com.sab.banking.dto.TransactionDto;
import com.sab.banking.models.Transaction;

public interface TransactionService extends AbstractService<TransactionDto> {

    List<Transaction> findAllByUserId(Integer UserId);
}