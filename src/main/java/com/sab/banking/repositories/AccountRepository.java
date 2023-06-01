package com.sab.banking.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sab.banking.models.Account;

public interface AccountRepository extends JpaRepository<Account, Integer> {
    Optional<Account> findByIban(String Iban);

    // methode utilisée lorsqu'on vérifie si l'utilisateur a déjà un compte
    Optional<Account> findByUserId(Integer id);
}
