package test.acntech.ddd.examples

import no.acntech.ddd.examples.SemanticVersion
import no.acntech.ddd.utils.lang.ValidationException

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertThrows
import org.junit.jupiter.api.Test

internal class SemanticVersionTest {

   @Test
   fun `test of string`() {
      val testSemanticVersion = "1.0.0-alpha+001"
      val result = SemanticVersion.of(testSemanticVersion)
      assertEquals(testSemanticVersion, result.unwrap())
   }

   @Test
   fun `test invalid Semantic version exception`() {
      val invalidTestString = "1.0.0-alpha+001-"
      assertThrows(ValidationException::class.java) { SemanticVersion.of(invalidTestString) }
   }

   @Test
   fun `check for string length above 127 characters`() {
      val invalidTestString =
         "1.0.1" +
            "-alpha.alpha.alpha.alpha.alpha.alpha.alpha.alpha.alpha.alpha.alpha" +
            "+build.build.build.build.build.build.build.build.build.build.build"
      assertThrows(ValidationException::class.java) { SemanticVersion.of(invalidTestString) }
   }

   @Test
   fun `test toString`() {
      val testSemanticVersion = "1.0.0-alpha+001"
      val semantic = SemanticVersion.of(testSemanticVersion)
      assertEquals(testSemanticVersion, semantic.toString())
   }
}