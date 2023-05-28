package com.sab.banking.services;

import org.hibernate.mapping.List;

public interface AbstractService<T> {

    Integer save(T dto);

    List<T> findAll();

    T findById(
            Integer id);

    void delete(Integer id);
}