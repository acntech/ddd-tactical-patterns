package no.acntech.ddd.model

/**
 * Represents a validation range for a comparable value.
 *
 * @param P the type of the value in the range, must implement Comparable
 * @property inclusiveMin the inclusive minimum value of the range (optional)
 * @property exclusiveMin the exclusive minimum value of the range (optional)
 * @property inclusiveMax the inclusive maximum value of the range (optional)
 * @property exclusiveMax the exclusive maximum value of the range (optional)
 */
data class ValidationRange<P : Comparable<P>>(
   val inclusiveMin: P? = null,
   val exclusiveMin: P? = null,
   val inclusiveMax: P? = null,
   val exclusiveMax: P? = null,
) {
   init {
      require(!(inclusiveMin != null && exclusiveMin != null)) {
         "Both inclusiveMin '$inclusiveMin' and exclusiveMin '$exclusiveMin' are set. They are mutually exclusive."
      }

      require(!(inclusiveMax != null && exclusiveMax != null)) {
         "Both inclusiveMax '$inclusiveMax' and exclusiveMax '$exclusiveMax' are set. They are mutually exclusive."
      }
   }
}