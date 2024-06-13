package no.acntech.ddd.examples;

import static org.apache.commons.lang3.Validate.isTrue;

import java.util.stream.IntStream;
import lombok.NonNull;
import no.acntech.ddd.model.StringValueObject;
import org.apache.commons.lang3.StringUtils;

public final class NorwegianOrganizationNumber extends StringValueObject {

    public static final int FIXED_LENGTH = 9;

    private static final int[] WEIGHTS = new int[]{3, 2, 7, 6, 5, 4, 3, 2};

    public static NorwegianOrganizationNumber of(String value) {
        return new NorwegianOrganizationNumber(value);
    }

    public NorwegianOrganizationNumber(String value) {
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
        isTrue(StringUtils.isNumeric(value), "NorwegianOrganizationNumber must be numeric [%s]", value);
    }

    @Override
    protected void validateSyntax(String value) {
        isTrue(validateChecksum(value), "NorwegianOrganizationNumber is not valid [%s]", value);
    }

    private static boolean validateChecksum(@NonNull String number) {
        int sum = IntStream.range(0, WEIGHTS.length)
            .map(i -> WEIGHTS[i] * Character.getNumericValue(number.charAt(i)))
            .sum();
        int remainder = Integer.remainderUnsigned(sum, 11);
        int control = (remainder == 0 ? 0 : 11 - remainder);

        return control == Character.getNumericValue(number.charAt(FIXED_LENGTH - 1));
    }

}
