package com.sab.banking.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.sab.banking.models.Contact;
import com.sab.banking.models.User;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class ContactDto {

    private Integer id;

    @NotNull
    @NotEmpty
    @NotBlank
    @Size(min = 6, max = 16)
    private String firstName;

    @NotNull
    @NotEmpty
    @NotBlank(message = "Ce champs ne doit pas être vide")
    @Size(min = 6, max = 16)
    private String lastName;

    @NotNull
    @NotEmpty
    @NotBlank(message = "Ce champs ne doit pas être vide")
    @Email
    private String email;

    @NotNull
    @NotEmpty
    @NotBlank(message = "Ce champs ne doit pas être vide")
    private String iban;

    private Integer userId;

    public static ContactDto fromEntity(Contact contact) {
        return ContactDto.builder()
                .id(contact.getId())
                .firstName(contact.getFirstName())
                .lastName(contact.getLastName())
                .email(contact.getEmail())
                .iban(contact.getIban())
                .userId(contact.getUser().getId())
                .build();
    }

    public static Contact toEntity(ContactDto contact) {
        return Contact.builder()
                .id(contact.getId())
                .firstName(contact.getFirstName())
                .lastName(contact.getLastName())
                .email(contact.getEmail())
                .iban(contact.getIban())
                .user(
                        User.builder()
                                .id(contact.getUserId())
                                .build())
                .build();
    }
}