package no.acntech.ddd.examples.address;

import static org.apache.commons.lang3.StringUtils.isNumeric;
import static org.apache.commons.lang3.Validate.isTrue;

import no.acntech.ddd.model.StringValueObject;

/**
 * Value object representing a Norwegian post(al) code which is a 4 digit number.
 */
public class PostCode extends StringValueObject {

    public static final int FIXED_LENGTH = 4;

    public static PostCode of(String value) {
        return new PostCode(value);
    }

    protected PostCode(String value) {
        super(value);
    }

    @Override
    public int getMinLength() {
        return FIXED_LENGTH;
    }

    @Override
    public int getMaxLength() {
        return FIXED_LENGTH;
    }

    @Override
    protected void validateLexicalContent(String value) {
        isTrue(isNumeric(value), "Postal code must be numeric [%s]", value);
    }

}
