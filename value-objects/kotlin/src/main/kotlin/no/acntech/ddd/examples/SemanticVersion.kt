package no.acntech.ddd.examples

import no.acntech.ddd.model.SimpleValueObject
import no.acntech.ddd.utils.text.StringValidator
import no.acntech.ddd.utils.text.RegexValidator

/**
 * Value object representing a file name for a file to be added or mapped into a container.
 */
@JvmInline
value class SemanticVersion(private val value: String) : SimpleValueObject<String> {

   companion object {

      // REGEXP: Matches semantic versions with major, minor, and patch numbers followed by optional pre-release identifiers
      // and build metadata. A version looks like this: [major].[minor].[patch]-[pre-release]+[build]
      private val REGEXP: Regex =
         "^([0-9]+)\\.([0-9]+)\\.([0-9]+)(-[a-zA-Z0-9]+(\\.[a-zA-Z0-9.-]*[a-zA-Z0-9])*)?(\\+[a-zA-Z0-9]+(\\.[a-zA-Z0-9.-]*[a-zA-Z0-9])*)?\$".toRegex()

      private val VALIDATOR = StringValidator(
         minLength = 1,
         maxLength = 127,
         lexicalValidator = RegexValidator(REGEXP)
      )

      fun of(value: String): SemanticVersion {
         return SemanticVersion(value)
      }
   }

   init {
      VALIDATOR.validate(this.unwrap())
   }

   override fun unwrap(): String {
      return value
   }

   fun getMajor(): Int {
      return value.split(".")[0].toInt()
   }

   fun getMinor(): Int {
      return value.split(".")[1].toInt()
   }

   fun getPatch(): Int {
      return value.split(".")[2].toInt()
   }

   fun getPreRelease(): String? {
      return value.split("-").getOrNull(1)
   }

   fun getBuildMetadata(): String? {
      return value.split("+").getOrNull(1)
   }

   override fun toString(): String {
      return value
   }

}
