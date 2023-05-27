package com.sab.banking.dto;

import java.math.BigDecimal;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import com.sab.banking.models.Transaction;
import com.sab.banking.models.TransactionType;
import com.sab.banking.models.User;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class TransactionDto {

    private Integer id;

    private BigDecimal mount;

    private TransactionType type;

    private String destinationIban;

    private Integer userId;

    public static TransactionDto fromEntity(Transaction transaction) {
        return TransactionDto.builder()
                .id(transaction.getId())
                .type(transaction.getType())
                .mount(transaction.getMount())
                .destinationIban(transaction.getDestinationIban())
                .userId(transaction.getUser().getId())
                .build();
    }

    public static Transaction toEntity(TransactionDto transaction) {
        return Transaction.builder()
                .id(transaction.getId())
                .type(transaction.getType())
                .mount(transaction.getMount())
                .destinationIban(transaction.getDestinationIban())
                .user(
                        User.builder()
                                .id(transaction.getUserId())
                                .build())
                .build();
    }
}