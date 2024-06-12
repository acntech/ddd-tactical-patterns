package no.acntech.ddd.utils.text

import no.acntech.ddd.utils.lang.ValidationException
import no.acntech.ddd.utils.lang.Validator

/**
 * A validator that uses regular expressions to validate strings.
 *
 * @property pattern The regular expression pattern used for validation.
 */
data class RegexValidator(val pattern: Regex) : Validator<String> {

   override fun validate(t: String) {
      if (!pattern.matches(t)) {
         throw ValidationException("String '$t' does not match the required regex pattern: ${pattern.pattern}")
      }
   }
}
