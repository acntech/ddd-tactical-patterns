package no.acntech.ddd.utils.lang

import no.acntech.ddd.utils.lang.ValidationException

/**
 *  Interface for validating objects.
 */
interface Validator<T> {

   /**
    * Validates the given object.
    *
    * @param t the object to validate
    * @throws ValidationException if the object is not valid
    */
   @Throws(ValidationException::class)
   fun validate(t: T)
}