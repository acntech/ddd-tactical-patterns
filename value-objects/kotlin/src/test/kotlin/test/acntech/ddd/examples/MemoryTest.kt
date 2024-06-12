package test.acntech.ddd.examples

import no.acntech.ddd.examples.Memory
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertThrows
import org.junit.jupiter.api.Test
import java.math.BigInteger

internal class MemoryTest {

   @Test
   fun `test of string`() {
      val testString = "20Mi"
      val result = Memory.of(testString)
      assertEquals(BigInteger("20971520"), result.unwrap())
   }

   @Test
   fun `test of BigInteger`() {
      val testBigInteger = BigInteger("10485760")
      val result = Memory.of(testBigInteger)
      assertEquals(testBigInteger, result.unwrap())
   }

   @Test
   fun `test toKi method`() {
      val testBigInteger = BigInteger("10485760")
      val memory = Memory.of(testBigInteger)
      assertEquals(testBigInteger.divide(Memory.Ki), memory.toKi())
   }

   @Test
   fun `test invalid memory format exception`() {
      val invalidTestString = "20Mib"
      assertThrows(IllegalArgumentException::class.java) { Memory.of(invalidTestString) }
   }

   @Test
   fun `test toFormattedString method`() {
      val testBigInteger = BigInteger("1024")
      val result = Memory.of(testBigInteger)
      assertEquals("1KiB", result.toFormattedString())
   }

   @Test
   fun `test toString method`() {
      val testString = "20Mi"
      val memory = Memory.of(testString)
      assertEquals(memory.toFormattedString(), memory.toString())
   }
}