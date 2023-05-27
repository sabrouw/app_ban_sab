package com.sab.banking.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.sab.banking.models.User;

public interface UserRepository extends JpaRepository<User, Integer> {

    List<User> findAllByfirstName(String firstName);

    List<User> findAllByAccountIban(String iban);

    @Query("from User where firstName = :firstName")
    List<User> searchByFirstName(String firstName);

    @Query("from User u inner join Account a on u.id = a.user.id")
    List<User> searchByIban(String iban);

}