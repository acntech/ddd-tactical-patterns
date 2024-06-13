package no.acntech.ddd.examples.address;

import static org.apache.commons.lang3.StringUtils.isNumeric;
import static org.apache.commons.lang3.Validate.isTrue;

import no.acntech.ddd.model.StringValueObject;

/**
 * Value object representing a Norwegian post(al) box which is a number between 1 and 16 digits that may start with leading zeros.
 */
public final class PostOfficeBox extends StringValueObject {

    public static final int MIN_LENGTH = 1;

    public static final int MAX_LENGTH = 16;

    public static PostOfficeBox of(String value) {
        return new PostOfficeBox(value);
    }

    public PostOfficeBox(String value) {
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
        isTrue(isNumeric(value), "Postal code must be numeric [%s]", value);
    }

}
