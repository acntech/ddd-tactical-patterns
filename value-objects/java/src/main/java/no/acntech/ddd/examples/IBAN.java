package no.acntech.ddd.examples;

import static org.apache.commons.lang3.Validate.isTrue;

import no.acntech.ddd.model.StringValueObject;
import org.apache.commons.validator.routines.IBANValidator;

public final class IBAN extends StringValueObject {

    public static final int MIN_LENGTH = 5;

    public static final int MAX_LENGTH = 34;

    public static IBAN of(String value) {
        return new IBAN(value);
    }

    public IBAN(String value) {
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
    public void validateSyntax(String value) {
        isTrue(IBANValidator.DEFAULT_IBAN_VALIDATOR.isValid(value), "Not a valid IBAN: %s", value);
    }

}
