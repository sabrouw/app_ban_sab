package com.sab.banking.services;

import com.sab.banking.dto.UserDto;

public interface UserService extends AbstractService<UserDto> {
    // retourner l'id de l'utilisateur lorsque le compte est crée
    Integer validateAccount(Integer id);

    // un utilisateur peut desactiver ou peut avoir son compte désactiver
    Integer inValidateAccount(Integer id);

}