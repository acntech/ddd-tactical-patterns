package test.acntech.ddd.examples

import no.acntech.ddd.examples.CPU
import no.acntech.ddd.utils.lang.ValidationException
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertThrows
import org.junit.jupiter.api.Test

internal class CPUTest {

   @Test
   fun `test of string with m suffix`() {
      val testString = "2000m"
      val result = CPU.of(testString)
      assertEquals(2.0, result.unwrap())
   }

   @Test
   fun `test of string without m suffix`() {
      val testString = "2"
      val result = CPU.of(testString)
      assertEquals(2.0, result.unwrap())
   }

   @Test
   fun `test of double`() {
      val testDouble = 1.5
      val result = CPU.of(testDouble)
      assertEquals(testDouble, result.unwrap())
   }

   @Test
   fun `test invalid CPU request limit exception`() {
      val invalidTestString = "abc"
      assertThrows(IllegalArgumentException::class.java) { CPU.of(invalidTestString) }
   }

   @Test
   fun `test toString method with m suffix`() {
      val testDouble = 0.5
      val cpu = CPU.of(testDouble)
      assertEquals("500m", cpu.toString())
   }

   @Test
   fun `test toString method without m suffix`() {
      val testDouble = 1.5
      val cpu = CPU.of(testDouble)
      assertEquals("1.5", cpu.toString())
   }
}