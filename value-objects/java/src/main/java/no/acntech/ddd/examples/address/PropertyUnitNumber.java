package no.acntech.ddd.examples.address;

import lombok.NonNull;
import no.acntech.ddd.model.StringValueObject;
import no.acntech.ddd.utils.lang.RegexValidator;
import no.acntech.ddd.utils.lang.Validator;

/**
 * Value object representing a <i>property unit number</i> ("Bruksenhetsnummer") - see e.g.
 * https://www.kartverket.no/eiendom/adressering/finn-bruksenhetsnummer-bolignummer
 * <p>
 * <ul>
 *  <li>The first letter indicates whether it is the basement (K), lower ground floor (U), main floor (H), or attic (L).</li>
 *  <li>The first two digits indicate the floor.</li>
 *  <li>The last two digits indicate the apartment number from left to right on the respective floor.</li>
 * </ul>
 * <p>
 * Example values: K0101, U0202, H0303, L0404
 */
public final class PropertyUnitNumber extends StringValueObject {

    public static final int FIXED_LENGTH = 5;

    private static final String REGEX = "^[KUHL]\\d{2}\\d{2}$";

    private static final Validator<String> VALIDATOR = RegexValidator.of(REGEX);

    public static PropertyUnitNumber of(String value) {
        return new PropertyUnitNumber(value);
    }

    public PropertyUnitNumber(@NonNull String value) {
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
    protected void validateSyntax(String value) {
        VALIDATOR.validate(value);
    }

}
