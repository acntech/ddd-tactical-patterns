package no.acntech.ddd.model;

import static org.apache.commons.lang3.Validate.isTrue;

import com.fasterxml.jackson.annotation.JsonValue;
import lombok.EqualsAndHashCode;
import lombok.NonNull;

/**
 * Simple implementation of a PrimitiveValueObject - range validation is performed via min/max comparable exploitation.
 */
@EqualsAndHashCode
public class SimpleValueObject<P extends Comparable<P>> implements PrimitiveValueObject<P> {

    private final P primitive;

    /**
     * Protected constructor - subclasses <i>must</i> call this in order for the framework to work. The primitive value is
     * validated by first checking the range extremes (if any) and then calling the possibly overridden {@link #validate} method.
     */
    protected SimpleValueObject(@NonNull P primitive) {
        validateRange(primitive);
        validate(primitive);
        this.primitive = primitive;
    }

    /**
     * Validates the primitive value given in the constructor - throws a (subclass of) {@link RuntimeException} (possibly an
     * {@link IllegalArgumentException} if the primitive is invalid. The default implementation does nothing. Note that range
     * validation is performed by the constructor prior to calling this method.
     *
     * @param primitive the primitive value.
     */
    protected void validate(P primitive) {
    }

    @JsonValue
    @Override
    public final P toPrimitive() {
        return primitive;
    }

    @Override
    public final String toString() {
        return primitive.toString();
    }

    /**
     * Override to return the inclusive minimum value, the default implementation returns null.
     *
     * @return the inclusive minimum value, or null of not applicable.
     */
    protected P getInclusiveMin() {
        return null;
    }

    /**
     * Override to return the inclusive maximum value, the default implementation returns null.
     *
     * @return the inclusive maximum value, or null of not applicable.
     */
    protected P getInclusiveMax() {
        return null;
    }

    /**
     * Override to return the exclusive minimum value, the default implementation returns null.
     *
     * @return the exclusive minimum value, or null of not applicable.
     */
    protected P getExclusiveMin() {
        return null;
    }

    /**
     * Override to return the exclusive maximum value, the default implementation returns null.
     *
     * @return the exclusive maximum value, or null of not applicable.
     */
    protected P getExclusiveMax() {
        return null;
    }

    private void validateRange(P value) {
        if (getInclusiveMin() != null && getExclusiveMin() != null) {
            throw new IllegalStateException(String.format(
                "Cannot have both inclusive [%s] and exclusive minimum [%s] values",
                getInclusiveMin(),
                getExclusiveMin()
            ));
        }

        if (getInclusiveMax() != null && getExclusiveMax() != null) {
            throw new IllegalStateException(String.format(
                "Cannot have both inclusive [%s] and exclusive maximum [%s] values",
                getInclusiveMax(),
                getExclusiveMax()
            ));
        }

        P extreme;

        isTrue((extreme = getInclusiveMin()) == null || value.compareTo(extreme) >= 0,
            "Value must be greater than or equal to [%s], but was [%s]", extreme, value);

        isTrue((extreme = getInclusiveMax()) == null || value.compareTo(extreme) <= 0,
            "Value must be less than or equal to [%s], but was [%s]", extreme, value);

        isTrue((extreme = getExclusiveMin()) == null || value.compareTo(extreme) > 0,
            "Value must be greater than [%s], but was [%s]", extreme, value);

        isTrue((extreme = getExclusiveMax()) == null || value.compareTo(extreme) < 0,
            "Value must be less than [%s], but was [%s]", extreme, value);
    }

}
