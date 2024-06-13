package no.acntech.ddd.examples.address;

import lombok.NonNull;
import no.acntech.ddd.model.StringValueObject;
import no.acntech.ddd.utils.lang.RegexValidator;
import no.acntech.ddd.utils.lang.Validator;

/**
 * Value object representing a Norwegian <i>address name</i> - see https://no.wikipedia.org/wiki/Adresse_(geografisk).
 */
public final class AddressName extends StringValueObject {

    public static final int MIN_LENGTH = 2;

    public static final int MAX_LENGTH = 64;

    //
    private static final String ADDRESS_NAME_REGEX = "^[a-zA-ZæøåÆØÅäöüÄÖÜ ]+$";;

    private static final Validator<String> VALIDATOR = RegexValidator.of(ADDRESS_NAME_REGEX);


    public static AddressName of(String value) {
        return new AddressName(value);
    }

    public AddressName(@NonNull String value) {
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
