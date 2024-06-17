package no.acntech.ddd.model;

import lombok.NonNull;

/**
 * A DDD ValueObject holding a single (primitive) value.
 *
 * A SimpleValueObject restricts the underlying value using domain specific rules - e.g. applying
 * range restrictions (for numbers), non-null, non-blank, length restrictions for Strings, etc.
 *
 * A SimpleValueObject is usually constructed using a single-argument constructor and/or
 * with a static <code>of(P p)</code> method.
 */
public interface PrimitiveValueObject<P extends Comparable<P>>
    extends ValueObject, Comparable<PrimitiveValueObject<P>> {

    /**
     * Returns the underlying primitive value.
     *
     * @return the primitive value
     */
    P toPrimitive();

    /**
     * Compares this object with the specified object for order.
     *
     * @param p the object to be compared
     * @return a negative integer, zero, or a positive integer as this object is less than, equal to, or greater than the specified object
     */
    default int compareTo(@NonNull PrimitiveValueObject<P> p) {
        return toPrimitive().compareTo(p.toPrimitive());
    }

}
