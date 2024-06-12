package no.acntech.ddd.utils.text

import no.acntech.ddd.utils.lang.RangeValidator
import no.acntech.ddd.utils.lang.Validator


/**
 * Validates a String value object based on a given range and additional validators.
 *
 * @param minLength the minimum length of the String value object (optional)
 * @param maxLength the maximum length of the String value object (optional)
 * @param rangeValidator the range validator for the String value object (optional)
 * @param lexicalValidator the lexical validator for the String value object (optional)
 * @param syntaxValidator the syntax validator for the String value object (optional)
 * @param semanticsValidator the semantics validator for the String value object (optional)
 */
class StringValidator(
   private val minLength: Int? = null,
   private val maxLength: Int? = null,
   private val rangeValidator: RangeValidator<String>? = null,
   private val lexicalValidator: Validator<String>? = null,
   private val syntaxValidator: Validator<String>? = null,
   private val semanticsValidator: Validator<String>? = null,
) : Validator<String> {

   override fun validate(t: String) {

      val lengthValidator = LengthValidator(minLength, maxLength)

      // Length checks
      lengthValidator.validate(t)

      // Range checks (alphabetical)
      rangeValidator?.validate(t)

      // Lexical content checks
      lexicalValidator?.validate(t)

      // Syntax checks
      syntaxValidator?.validate(t)

      // Semantics checks
      semanticsValidator?.validate(t)
   }
}
