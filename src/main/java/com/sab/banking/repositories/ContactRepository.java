package com.sab.banking.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sab.banking.models.Contact;

public interface ContactRepository extends JpaRepository<Contact, Integer> {
    List<Contact> findAllByfirstName(String firstname);
}