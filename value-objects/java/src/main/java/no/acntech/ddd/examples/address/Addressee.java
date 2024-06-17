package no.acntech.ddd.examples.address;

import lombok.NonNull;
import no.acntech.ddd.model.StringValueObject;
import no.acntech.ddd.utils.text.RegexValidator;
import no.acntech.ddd.utils.lang.Validator;

/**
 * Value object representing a Norwegian <i>addressee</i> stated on the first line of a postal address - see
 * https://no.wikipedia.org/wiki/Adresse_(geografisk).
 */
public final class Addressee extends StringValueObject {

    public static final int MIN_LENGTH = 2;

    public static final int MAX_LENGTH = 64;

    private static final String REGEX = "^[a-zA-ZæøåÆØÅäöüÄÖÜ ]+$";

    private static final Validator<String> VALIDATOR = RegexValidator.of(REGEX);

    public static Addressee of(String value) {
        return new Addressee(value);
    }

    public Addressee(@NonNull String value) {
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
