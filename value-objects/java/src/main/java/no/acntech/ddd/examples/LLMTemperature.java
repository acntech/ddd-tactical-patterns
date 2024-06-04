package no.acntech.ddd.examples;

import lombok.NonNull;
import no.acntech.ddd.model.SimpleValueObject;

public class LLMTemperature extends SimpleValueObject<Float> {

  public static final float MIN_VALUE = 0.0f;

  public static final float MAX_VALUE = 1.0f;

  public static final LLMTemperature MIN = new LLMTemperature(MIN_VALUE);

  public static final LLMTemperature MAX = new LLMTemperature(MAX_VALUE);

  public static final LLMTemperature DETERMINISTIC = MIN;

  public static final LLMTemperature FOCUSED = new LLMTemperature(0.2f);

  public static final LLMTemperature MODERATE = new LLMTemperature(0.5f);

  public static final LLMTemperature DEFAULT = new LLMTemperature(0.7f);

  public static final LLMTemperature ADVENTUROUS = MAX;

  public static final LLMTemperature IMAGINATIVE = new LLMTemperature(0.9f);

  public static LLMTemperature of(String value) {
    return new LLMTemperature(Float.parseFloat(value));
  }

  public static LLMTemperature of(Float value) {
    return new LLMTemperature(value);
  }

  protected LLMTemperature(@NonNull Float primitive) {
    super(primitive);
  }

  protected Float getInclusiveMin() {
    return MIN_VALUE;
  }

  protected Float getInclusiveMax() {
    return MAX_VALUE;
  }

}
