package com.sab.banking.dto;

import com.sab.banking.models.Address;
import com.sab.banking.models.User;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class AddressDto {
    private Integer id;

    @NotNull
    @NotEmpty
    @NotBlank(message = "Ce champs ne doit pas être vide")
    private String street;

    @NotNull
    @NotEmpty
    @NotBlank(message = "Ce champs ne doit pas être vide")
    private Integer houseNumber;

    @NotNull
    @NotEmpty
    @NotBlank(message = "Ce champs ne doit pas être vide")
    @Max(value = 5)
    private Integer zipCode;

    @NotNull
    @NotEmpty
    @NotBlank(message = "Ce champs ne doit pas être vide")
    private String city;

    @NotNull
    @NotEmpty
    @NotBlank(message = "Ce champs ne doit pas être vide")
    private String country;

    private Integer userId;

    public static AddressDto fromEntity(Address address) {
        return AddressDto.builder()
                .id(address.getId())
                .street(address.getStreet())
                .houseNumber(address.getHouseNumber())
                .zipCode(address.getZipCode())
                .city(address.getCity())
                .country(address.getCountry())
                .userId(address.getUser().getId())
                .build();
    }

    public static Address toEntity(AddressDto address) {
        return Address.builder()
                .id(address.getId())
                .street(address.getStreet())
                .houseNumber(address.getHouseNumber())
                .zipCode(address.getZipCode())
                .city(address.getCity())
                .country(address.getCountry())
                // On fait un builder pour l'id user à partir de l'entité userdto
                .user(
                        User.builder()
                                .id(address.getUserId())
                                .build())
                .build();

    }
}