package com.sab.banking.services;

import java.util.List;

import com.sab.banking.dto.ContactDto;
import com.sab.banking.models.Contact;

public interface ContactService extends AbstractService<ContactDto> {
    List<Contact> findAllByUserId(Integer userId);
}