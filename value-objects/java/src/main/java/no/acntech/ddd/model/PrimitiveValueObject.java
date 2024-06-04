package no.acntech.ddd.model;

import lombok.NonNull;

/**
 * A DDD ValueObject holding a simple primitive, ({@link java.util.Date}, {@link Integer}, {@link Double}, {@link Float},
 * {@link java.math.BigDecimal}, {@link Long}, {@link Short}, {@link Boolean} etc - possibly another {@link PrimitiveValueObject}.
 * The {@link #toPrimitive()} method can e.g. assist in mapping the {@link PrimitiveValueObject} from a DTO or from a repository
 * object.
 * <p>
 * The {@link PrimitiveValueObject} would normally restrict the primitive using domain specific rules - e.g. applying range
 * restrictions (for numbers), non-null, non-blank and length restrictions for Strings, etc.
 * <p>
 * A {@link PrimitiveValueObject} is usually constructed using a single-argument constructor or (even better) with a a static
 * <code>of(Primitive p)</code> method - or both.
 * </p>
 */
public interface PrimitiveValueObject<P extends Comparable<P>>
    extends ValueObject, Comparable<PrimitiveValueObject<P>> {

  P toPrimitive();

  default int compareTo(@NonNull PrimitiveValueObject<P> p) {
    return toPrimitive().compareTo(p.toPrimitive());
  }

}
