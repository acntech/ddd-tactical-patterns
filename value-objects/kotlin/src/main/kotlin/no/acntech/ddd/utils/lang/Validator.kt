package no.acntech.ddd.utils.lang

/**
 *  Interface for validating objects of a certain type.
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