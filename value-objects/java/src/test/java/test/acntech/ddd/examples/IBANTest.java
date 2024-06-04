package test.acntech.ddd.examples;

import static org.junit.jupiter.api.Assertions.assertThrows;

import no.acntech.ddd.examples.IBAN;
import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.Test;

public class IBANTest {

  @Test
  public void testCreationOfValidIBAN() {
    IBAN.of("NO8924001356107");
  }

  @Test
  public void testCreationOfInvalidIBAN() {
    assertThrows(IllegalArgumentException.class, () -> IBAN.of("Invalid IBAN"));
  }

  @Test
  public void testIBANWithInvalidLength() {
    assertThrows(IllegalArgumentException.class, () -> IBAN.of(StringUtils.repeat("a", IBAN.MAX_LENGTH + 1)));
  }
}