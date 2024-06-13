package no.acntech.ddd.examples;

import lombok.NonNull;
import no.acntech.ddd.model.SimpleValueObject;

/**
 * Value object representing an LLM <i>temperature</i> - see https://www.iguazio.com/glossary/llm-temperature/
 */
public class Temperature extends SimpleValueObject<Float> {

    public static final float MIN_VALUE = 0.0f;

    public static final float MAX_VALUE = 1.0f;

    public static final Temperature MIN = new Temperature(MIN_VALUE);

    public static final Temperature MAX = new Temperature(MAX_VALUE);

    public static final Temperature DETERMINISTIC = MIN;

    public static final Temperature FOCUSED = new Temperature(0.2f);

    public static final Temperature MODERATE = new Temperature(0.5f);

    public static final Temperature DEFAULT = new Temperature(0.7f);

    public static final Temperature IMAGINATIVE = new Temperature(0.9f);

    public static final Temperature ADVENTUROUS = MAX;

    public static Temperature of(String value) {
        return new Temperature(Float.parseFloat(value));
    }

    public static Temperature of(Float value) {
        return new Temperature(value);
    }

    protected Temperature(@NonNull Float primitive) {
        super(primitive);
    }

    protected Float getInclusiveMin() {
        return MIN_VALUE;
    }

    protected Float getInclusiveMax() {
        return MAX_VALUE;
    }

}
