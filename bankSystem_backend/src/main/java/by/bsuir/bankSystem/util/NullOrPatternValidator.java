package by.bsuir.bankSystem.util;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class NullOrPatternValidator implements ConstraintValidator<NullOrPattern, String> {
    private String pattern;

    public void initialize(NullOrPattern constraintAnnotation) {
        this.pattern = constraintAnnotation.pattern();
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (value == null || value.isEmpty()) {
            return true;
        }
        return value.matches(pattern);
    }
}
