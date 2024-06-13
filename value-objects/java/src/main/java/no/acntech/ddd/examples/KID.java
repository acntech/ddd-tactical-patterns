package no.acntech.ddd.examples;

import static org.apache.commons.lang3.Validate.isTrue;

import no.acntech.ddd.model.StringValueObject;
import org.apache.commons.lang3.StringUtils;

/**
 * Value object representing a Norwegian <i>KID</i> - see https://no.wikipedia.org/wiki/KID-nummer.
 */
public final class KID extends StringValueObject {

    public static final int MIN_LENGTH = 2;

    public static final int MAX_LENGTH = 25;

    // Weights according to the KID system - modulo 10
    private static final int[] WEIGHTS = new int[]{2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2};

    public static KID of(String value) {
        return new KID(value);
    }

    public KID(String value) {
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
    protected void validateLexicalContent(String val) {
        isTrue(StringUtils.isNumeric(val), "KID must be numeric [%s]", val);
    }

    @Override
    protected void validateSyntax(String val) {
        isTrue(validateChecksum(val), "KID is not valid [%s]", val);
    }

    private boolean validateChecksum(String kid) {
        int length = kid.length();
        int sum = 0;
        for (int i = 0; i < length; i++) {
            int weighted = WEIGHTS[length - i - 1] * Character.getNumericValue(kid.charAt(i));
            sum += weighted < 10 ? weighted : 1 + weighted % 10;
        }
        return sum % 10 == 0;
    }

}
