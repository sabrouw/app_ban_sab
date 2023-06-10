package com.sab.banking.services;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Map;

public interface StatisticsService {

    // on retourne une liste de transaction d'une date de début à une date de fin
    // Map<LocalDate, BigDecimal> findSumTransactionsByDate(LocalDate startDate,
    // LocalDate endDate, Integer userId);

    // On renvoie une bigdecimale pour le solde de compte de l'utilisateur
    BigDecimal getAccountBalance(Integer userId);

    // le plus haut montant transféré
    BigDecimal highestTransfer(Integer userId);

    // le plus haut montant déposé
    BigDecimal highestDeposit(Integer userId);
}