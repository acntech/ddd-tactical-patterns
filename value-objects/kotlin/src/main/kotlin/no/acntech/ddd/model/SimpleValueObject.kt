package no.acntech.ddd.model

/**
 * A DDD ValueObject holding a single (primitive) value.
 *
 * A SimpleValueObject restricts the underlying value using domain specific rules - e.g. applying
 * range restrictions (for numbers), non-null, non-blank, length restrictions for Strings, etc.
 *
 * A SimpleValueObject is usually constructed using a single-argument constructor and/or
 * with a static <code>of(P p)</code> method.
 */
interface SimpleValueObject<P : Comparable<P>> : ValueObject, Comparable<SimpleValueObject<P>> {

   fun unwrap(): P

   override fun compareTo(other: SimpleValueObject<P>): Int {
      return unwrap().compareTo(other.unwrap())
   }

}
