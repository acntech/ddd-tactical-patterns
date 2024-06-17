package no.acntech.ddd.examples.address;

import lombok.NonNull;
import no.acntech.ddd.model.StringValueObject;
import no.acntech.ddd.utils.text.RegexValidator;
import no.acntech.ddd.utils.lang.Validator;

/**
 * Value object representing a Norwegian post(al) code area which consists of letters and spaces.
 */
public final class PostCodeArea extends StringValueObject {

    public static final int MIN_LENGTH = 4;

    public static final int MAX_LENGTH = 64;

    private static final String REGEX = "^[a-zA-ZæøåÆØÅ]+(\\s[a-zA-ZæøåÆØÅ]+)*$";

    private static final Validator<String> VALIDATOR = RegexValidator.of(REGEX);

    public static PostCodeArea of(String value) {
        return new PostCodeArea(value);
    }

    public PostCodeArea(@NonNull String value) {
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
