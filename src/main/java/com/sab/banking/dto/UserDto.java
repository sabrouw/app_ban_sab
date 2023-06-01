package com.sab.banking.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.sab.banking.models.User;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class UserDto {

    private Integer id;

    @NotNull
    @NotEmpty
    @NotBlank(message = "Ce champs ne doit pas être vide")
    @Size(min = 6, max = 16)
    private String firstName;

    @NotNull
    @NotEmpty
    @NotBlank(message = "Ce champs ne doit pas être vide")
    @Size(min = 6, max = 16)
    private String lastName;

    @NotNull
    @NotEmpty
    @Email
    @NotBlank(message = "Ce champs ne doit pas être vide")
    private String email;

    @NotNull
    @NotEmpty
    @NotBlank(message = "Ce champs ne doit pas être vide")
    @Size(min = 6, max = 16)
    private String password;

    public static UserDto fromEntity(User user) {
        return UserDto.builder()
                .id(user.getId())
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .email(user.getEmail())
                .password(user.getPassword())
                .build();
    }

    public static User toEntity(UserDto user) {
        return User.builder()
                .id(user.getId())
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .email(user.getEmail())
                .password(user.getPassword())
                .build();
    }

}