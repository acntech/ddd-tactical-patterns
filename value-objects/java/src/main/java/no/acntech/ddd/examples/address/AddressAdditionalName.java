package no.acntech.ddd.examples.address;

import lombok.NonNull;
import no.acntech.ddd.model.StringValueObject;
import no.acntech.ddd.utils.text.RegexValidator;
import no.acntech.ddd.utils.lang.Validator;

/**
 * Value object representing a Norwegian <i>address additional name</i> - see
 * https://www.kartverket.no/eiendom/adressering/adressetilleggsnavn
 */
public final class AddressAdditionalName extends StringValueObject {

    public static final int MIN_LENGTH = 2;

    public static final int MAX_LENGTH = 64;

    private static final String REGEX = "^[a-zA-ZæøåÆØÅäöüÄÖÜ ]+$";

    private static final Validator<String> VALIDATOR = RegexValidator.of(REGEX);

    public static AddressAdditionalName of(String value) {
        return new AddressAdditionalName(value);
    }

    public AddressAdditionalName(@NonNull String value) {
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
