package no.acntech.ddd.model;

import static org.apache.commons.lang3.Validate.inclusiveBetween;

import no.acntech.ddd.utils.text.StringUtils;

/**
 * A simple value object backed by a {@link java.lang.String}.
 * <p>
 * Override  {@link #getMinLength()} and {@link #getMaxLength()} to validate the length of the String.
 * <p>
 * Override  {@link #validateLexicalContent(String)}, {@link #validateSyntax(String)} and {@link #validateSemantics(String)} to
 * validate different aspects of the String contents.
 * <p>
 * Note that the methods {@link #getInclusiveMin()}, {@link #getInclusiveMax()}, * {@link #getExclusiveMin()} and
 * {@link #getExclusiveMax()} may be implemented, and will then constitute extremes with regards to the internal primitive's
 * natural sorting - hence would be pretty rare domain value restrictions. An example could be a StringValueObject representing a
 * version number (String), restricted with a min and a max value, e.g. "v0.1" and "v9.9".
 */
public class StringValueObject extends SimpleValueObject<String> {

    protected StringValueObject(String value) {
        super(value);
    }

    protected final void validate(String value) {
        validateLength(value);
        validateLexicalContent(value);
        validateSyntax(value);
        validateSemantics(value);
    }

    /**
     * Returns the required minimum length of the (internal) String. The default implementation returns 0.
     *
     * @return the required minimum length of the (internal) String.
     */
    public int getMinLength() {
        return 0;
    }

    /**
     * Returns the required maximum length of the (internal) String. The default implementation returns
     * {@link Integer#MAX_VALUE}.
     *
     * @return the required maximum length of the (internal) String.
     */
    public int getMaxLength() {
        return Integer.MAX_VALUE;
    }

    /**
     * Validates the lexical content of a string value.
     *
     * @param value the string value to be validated
     */
    protected void validateLexicalContent(String value) {
        // do nothing
    }

    /**
     * Validates the syntax of a string value.
     *
     * @param value the string value to be validated
     */
    protected void validateSyntax(String value) {
        // do nothing
    }

    /**
     * Validates the semantics of a string value.
     *
     * @param value the string value to be validated
     */
    protected void validateSemantics(String value) {
        // do nothing
    }

    private void validateLength(String value) {
        int length = value.length();

        inclusiveBetween(
            getMinLength(),
            getMaxLength(),
            length,
            "Length of [%s] must be between [%s] and [%s], but was [%s]",
            StringUtils.truncate(value, 32, false, true),
            getMinLength(),
            getMaxLength(),
            length);
    }

}
