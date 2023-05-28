package com.sab.banking.services.impl;

import java.util.stream.Collector;
import java.util.stream.Collectors;

import javax.persistence.EntityNotFoundException;

import org.apache.tomcat.jni.User;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository repository;
    private final ObjectsValidator<UserDto> objectsValidator;

    @Override
    public Integer save(UserDto dto) {
        // on valide notre objet avec la gestion d'exeption globale
        validator.validate(dto);
        // si l'objet est validé on persiste les données
        // on transforme le userdto en objet user
        User user = UserDto.toEntity(dto);
        // on persiste la donnée
        return repository.save(user).getId();
    }

    @Override
    public List<UserDto> findAll() {
        return repository.findAll()
                // parcours ma liste utilisateurs et les renvoyer transformer en dto
                .stream()
                .map(userDto::fromEntity)
                // assemble les informations
                .collect(Collectors.toList());
    }

    @Override
    public UserDto findById(Integer id) {
        return repository.findById(id)
                .map(userDto::fromEntity)
                .orElseThrow(() -> new EntityNotFoundException("pas d'utilisateur trouvé"));
    }

    @Override
    public void delete(Integer id) {
        // VERIFIER que l'utilisateur n'a ps un compte car on supprime toutes les
        // dépendance aussi
        repository.deleteById(id);
    }
}