package no.acntech.ddd.examples.address;

import lombok.NonNull;
import no.acntech.ddd.model.StringValueObject;
import no.acntech.ddd.utils.lang.RegexValidator;
import no.acntech.ddd.utils.lang.Validator;

/**
 * Value object representing a Norwegian post(al) code area which consists of letters and spaces.
 */
public final class UnitNumber extends StringValueObject {

    public static final int MIN_LENGTH = 5;

    public static final int MAX_LENGTH = 5;

    private static final String REGEX = "^[KUHL]\\d{2}\\d{2}$";

    private static final Validator<String> VALIDATOR = RegexValidator.of(REGEX);

    public static UnitNumber of(String value) {
        return new UnitNumber(value);
    }

    public UnitNumber(@NonNull String value) {
        super(value);
    }

    @Override
    public int getMinLength() {
        return MIN_LENGTH;
    }

    @Override
    public int getMaxLength() {
        return MAX_LENGTH;
    }

    @Override
    protected void validateSyntax(String value) {
        VALIDATOR.validate(value);
    }

}
