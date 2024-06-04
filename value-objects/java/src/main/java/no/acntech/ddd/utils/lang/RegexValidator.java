package no.acntech.ddd.utils.lang;

import java.util.Objects;
import java.util.regex.Pattern;

public class RegexValidator implements Validator<String> {

  private final Pattern pattern;

  public RegexValidator(String pattern) {
    this(Pattern.compile(pattern));
  }

  public RegexValidator(Pattern pattern) {
    this.pattern = pattern;
  }

  @Override
  public void validate(String t) {
    if (!pattern.matcher(t).matches()) {
      throw new ValidationException("String '" + t + "' does not match the required regex pattern: " + pattern);
    }
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) {
      return true;
    }
    if (!(other instanceof RegexValidator that)) {
      return false;
    }
    return Objects.equals(pattern.pattern(), that.pattern.pattern());
  }

  @Override
  public int hashCode() {
    return Objects.hash(pattern.pattern());
  }

  @Override
  public String toString() {
    return pattern.pattern();
  }
}