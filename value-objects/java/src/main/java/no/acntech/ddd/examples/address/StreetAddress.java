package no.acntech.ddd.examples.address;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NonNull;
import lombok.ToString;
import no.acntech.ddd.model.ValueObject;

/**
 * Value object representing a Norwegian street address. See https://no.wikipedia.org/wiki/Adresse_(geografisk).
 */
@EqualsAndHashCode
@ToString
@Getter
public final class StreetAddress implements ValueObject {

    private final AddressName name;

    private final AddressNumber number;

    private final AddressAdditionalName additionalName;

    private final UnitNumber unitNumber;

    public StreetAddress(@NonNull AddressName name, @NonNull AddressNumber number) {
        this(name, number, null, null);
    }

    public StreetAddress(
        @NonNull AddressName name,
        @NonNull AddressNumber number,
        AddressAdditionalName additionalName,
        UnitNumber unitNumber
    ) {
        this.name = name;
        this.number = number;
        this.additionalName = additionalName;
        this.unitNumber = unitNumber;
    }

}
