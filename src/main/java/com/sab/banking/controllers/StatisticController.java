package com.sab.banking.controllers;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sab.banking.services.StatisticsService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/statistics")
@RequiredArgsConstructor
public class StatisticController {

    private final StatisticsService service;

    // @GetMapping("/sum-by-date/{user-id}")
    // public ResponseEntity<Map<LocalDate, BigDecimal>> findSumTransactionsByDate(
    // @RequestParam("start-date") LocalDate startDate,
    // @RequestParam("end-date") LocalDate endDate,
    // @PathVariable("user-id") Integer userId) {
    // return ResponseEntity.ok(service.findSumTransactionsByDate(startDate,
    // endDate, userId));
    //
    // };

    @GetMapping("/account-balance/{user-id}")
    public ResponseEntity<BigDecimal> getAccountBalance(@PathVariable("user-id") Integer userId) {
        return ResponseEntity.ok(service.getAccountBalance(userId));
    };

    @GetMapping("/highest-transfer/{user-id}")
    public ResponseEntity<BigDecimal> highestTransfer(@PathVariable("user-id") Integer userId) {
        return ResponseEntity.ok(service.highestTransfer(userId));
    };

    @GetMapping("/highest-deposit/{user-id}")
    public ResponseEntity<BigDecimal> highestDeposit(@PathVariable("user-id") Integer userId) {
        return ResponseEntity.ok(service.highestDeposit(userId));
    };
};
