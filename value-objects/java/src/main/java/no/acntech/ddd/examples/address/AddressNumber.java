package no.acntech.ddd.examples.address;

import lombok.NonNull;
import no.acntech.ddd.model.StringValueObject;
import no.acntech.ddd.utils.lang.RegexValidator;
import no.acntech.ddd.utils.lang.Validator;

/**
 * Value object representing an <i>address number</i> - e.g. "12B" in "Øvre Bogenvei 12B".
 * AddressNumber is part of a {@link StreetAddress}.
 */
public final class AddressNumber extends StringValueObject {

    public static final int MIN_LENGTH = 1;

    public static final int MAX_LENGTH = 8;

    //
    private static final String REGEX = "^\\d+[a-zA-Z]?$";
    ;

    private static final Validator<String> VALIDATOR = RegexValidator.of(REGEX);


    public static AddressNumber of(String value) {
        return new AddressNumber(value);
    }

    public AddressNumber(@NonNull String value) {
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
