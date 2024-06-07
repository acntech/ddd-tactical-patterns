package no.acntech.ddd.model

import no.acntech.ddd.utils.lang.ValidationException
import no.acntech.ddd.utils.lang.Validator
import no.acntech.ddd.utils.text.truncate


/**
 * Validates a String value object based on a given range and additional validators.
 *
 * @param range the validation range for the String value object (default is an empty range)
 * @param minLength the minimum length of the String value object (optional)
 * @param maxLength the maximum length of the String value object (optional)
 * @param lexicalValidator the lexical validator for the String value object (optional)
 * @param syntaxValidator the syntax validator for the String value object (optional)
 * @param semanticsValidator the semantics validator for the String value object (optional)
 */
class StringValueObjectValidator(
   range: ValidationRange<String> = ValidationRange(),
   private val minLength: Int? = null,
   private val maxLength: Int? = null,
   private val lexicalValidator: Validator<String>? = null,
   private val syntaxValidator: Validator<String>? = null,
   private val semanticsValidator: Validator<String>? = null,
) : SimpleValueObjectValidator<String>(range) {

   override fun validate(t: SimpleValueObject<String>) {
      super.validate(t) // Call base class validation

      val value = t.unwrap()

      // Length checks
      minLength?.let { min ->
         if (value.length < min) {
            throw ValidationException("String length '${value.length}' below allowed minimum '$min' for value '$value'")
         }
      }

      maxLength?.let { max ->
         if (value.length > max) {
            throw ValidationException(
               "String length '${value.length}' exceeds allowed" +
                  " maximum '$max' for value '${value.truncate(32)}'"
            )
         }
      }

      // Lexical content checks
      lexicalValidator?.validate(value)

      // Syntax checks
      syntaxValidator?.validate(value)

      // Semantics checks
      semanticsValidator?.validate(value)
   }
}