package vn.test.accountmanager.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import java.util.Set;

public class ValidGenderValidator implements ConstraintValidator<ValidGender, String> {

    private static final Set<String> ALLOWED_GENDERS = Set.of("MALE", "FEMALE", "OTHER");

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (value == null || value.trim().isEmpty()) {
            return true;
        }
        return ALLOWED_GENDERS.contains(value.toUpperCase());
    }
}