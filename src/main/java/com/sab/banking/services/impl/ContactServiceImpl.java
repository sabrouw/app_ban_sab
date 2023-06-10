package com.sab.banking.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.EntityNotFoundException;

import org.springframework.stereotype.Service;

import com.sab.banking.ObjectsValidator;
import com.sab.banking.dto.ContactDto;
import com.sab.banking.models.Contact;
import com.sab.banking.repositories.ContactRepository;
import com.sab.banking.services.ContactService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ContactServiceImpl implements ContactService {

    private final ContactRepository repository;
    private final ObjectsValidator<ContactDto> validator;

    @Override
    public Integer save(ContactDto dto) {
        validator.validate(dto);
        Contact contact = ContactDto.toEntity(dto);
        return repository.save(contact).getId();
    }

    @Override
    public List<ContactDto> findAll() {
        return repository.findAll()
                .stream()
                .map(ContactDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public ContactDto findById(Integer id) {
        return repository.findById(id)
                .map(ContactDto::fromEntity)
                .orElseThrow(() -> new EntityNotFoundException("pas de contact trouvé"));
    }

    @Override
    public void delete(Integer id) {
        repository.deleteById(id);
    }

    // @Override
    // public List<ContactDto> findAllByUserId(Integer userId) {
    // return repository.findAllByUserId(userId)
    // .stream()
    // .map(ContactDto::fromEntity)
    // .collect(Collectors.toList());
    //
    // }
}