package com.sab.banking.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sab.banking.models.Address;

public interface AddressRepository extends JpaRepository<Address, Integer> {
    List<Address> findAllByStreet(String street);
}