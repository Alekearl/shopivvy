package com.ivvysoft.shop.annotation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class EmailValidator implements ConstraintValidator<EmailValidatorConstraint, String> {
    private static final String REGEX_MAIL_VALIDATOR = "^(.+)@(.+)$";

    @Override
    public boolean isValid(String emailField, ConstraintValidatorContext context) {

        return emailField != null && emailField.matches(REGEX_MAIL_VALIDATOR);
    }
}
