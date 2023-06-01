package com.sab.banking.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.EntityNotFoundException;

import org.iban4j.CountryCode;
import org.iban4j.Iban;
import org.springframework.stereotype.Service;

import com.sab.banking.ObjectsValidator;
import com.sab.banking.dto.AccountDto;
import com.sab.banking.models.Account;
import com.sab.banking.repositories.AccountRepository;
import com.sab.banking.services.AccountService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService {

    private final AccountRepository repository;
    private final ObjectsValidator<AccountDto> validator;

    @Override
    public Integer save(AccountDto dto) {

        // vérifier si l'utilisateur a déjà un compte et si l'iban n'est pas déjà
        // utilisé
        validator.validate(dto);
        Account account = AccountDto.toEntity(dto);
        boolean userHasAlreadyAnAccount = repository.findByUserId(account.getUser().getId()).isPresent();
        if (userHasAlreadyAnAccount)
            // voir pourquoi cette méthode OperationNonPermittedException n'xiste pas !
            // throw new OperationNonPermittedException(
            // "Uilisateur a déjà un compte chez nous!",
            // "Create account",
            // "Account service",
            // "Account creation");
            if (dto.getId() != null) {
                account.setIban(generateRandomIban());
            }
        return repository.save(account).getId();
    }

    @Override
    public List<AccountDto> findAll() {
        return repository.findAll()
                .stream()
                .map(AccountDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public AccountDto findById(Integer id) {
        return repository.findById(id)
                .map(AccountDto::fromEntity)
                .orElseThrow(() -> new EntityNotFoundException("pas de compte trouvé"));
    }

    @Override
    public void delete(Integer id) {
        repository.deleteById(id);
    }

    private String generateRandomIban() {
        String iban = Iban.random(CountryCode.DE).getBban();
        boolean ibanExists = repository.findByIban(iban)
                .isPresent();
        if (ibanExists) {
            generateRandomIban();
        }
        return iban;
    }
}