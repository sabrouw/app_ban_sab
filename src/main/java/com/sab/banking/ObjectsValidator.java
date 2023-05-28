package com.sab.banking;

import javax.validation.Validation;
import javax.validation.ValidatorFactory;

//<T> Rend une classe generique objet Typé
public class ObjectsValidator<T> {

    private final ValidatorFactory factory = Validation.buildDefaultValidatorFactory();

    private final Validator validator = factory.getValidator();

    // méthode de validation
    public void validate(T objectToValidate) {

    }
}