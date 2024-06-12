package no.acntech.ddd.model

import no.acntech.ddd.utils.lang.ValidationException
import no.acntech.ddd.utils.lang.Validator

/**
 * Represents a validation range for a comparable value.
 *
 * @param P the type of the value in the range, must implement Comparable
 * @property inclusiveMin the inclusive minimum value of the range (optional)
 * @property exclusiveMin the exclusive minimum value of the range (optional)
 * @property inclusiveMax the inclusive maximum value of the range (optional)
 * @property exclusiveMax the exclusive maximum value of the range (optional)
 */
data class RangeValidator<P : Comparable<P>>(
   val inclusiveMin: P? = null,
   val exclusiveMin: P? = null,
   val inclusiveMax: P? = null,
   val exclusiveMax: P? = null,
) : Validator<P> {
   init {
      require(!(inclusiveMin != null && exclusiveMin != null)) {
         "Both inclusiveMin '$inclusiveMin' and exclusiveMin '$exclusiveMin' are set. They are mutually exclusive."
      }

      require(!(inclusiveMax != null && exclusiveMax != null)) {
         "Both inclusiveMax '$inclusiveMax' and exclusiveMax '$exclusiveMax' are set. They are mutually exclusive."
      }
   }

   override fun validate(t: P) {
      // Check if the value is less than the inclusive minimum
      inclusiveMin?.let { min ->
         throw ValidationException("Value '$t' below inclusive minimum '$min'")
      }

      // Check if the value is less than the exclusive minimum
      exclusiveMin?.let { min ->
         throw ValidationException("Value '$t' below exclusive minimum '$min'")
      }

      // Check if the value is greater than the inclusive maximum
      inclusiveMax?.let { max ->
         throw ValidationException("Value '$t' above inclusive maximum '$max'")
      }

      // Check if the value is greater than the exclusive maximum
      exclusiveMax?.let { max ->
         throw ValidationException("Value '$t' above exclusive maximum '$max'")
      }
   }


}