package com.sab.banking.services;

import java.util.List;

import com.sab.banking.dto.TransactionDto;

public interface TransactionService extends AbstractService<TransactionDto> {

    List<TransactionDto> findAllByUserId(Integer userId);
}