package com.sab.banking.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sab.banking.models.User;

public interface UserRepository extends JpaRepository<User, Integer> {

    List<User> findAllByFirstName(String firstName);

    Optional<User> findByEmail(String email);

}