package no.acntech.ddd.examples;

import java.util.regex.Pattern;
import no.acntech.ddd.model.StringValueObject;
import no.acntech.ddd.utils.lang.RegexValidator;
import no.acntech.ddd.utils.lang.Validator;

/**
 * Value object representing an email address.
 */
public final class EmailAddress extends StringValueObject {

    public static final int MIN_LENGTH = 3;

    // The limit depends on the standard followed, 254 is based on RFC 5321
    public static final int MAX_LENGTH = 254;

    public static final Validator<String> PATTERN_VALIDATOR =
        new RegexValidator(Pattern.compile("[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}", Pattern.CASE_INSENSITIVE));

    public static EmailAddress of(String value) {
        return new EmailAddress(value);
    }

    public EmailAddress(String value) {
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
        PATTERN_VALIDATOR.validate(value);
    }

}
