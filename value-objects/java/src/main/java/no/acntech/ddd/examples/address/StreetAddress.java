package no.acntech.ddd.examples.address;

import static no.acntech.ddd.utils.text.StringLiterals.SPACE;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import no.acntech.ddd.model.ValueObject;

/**
 * Value object representing a Norwegian <i>street address</i></i>. See https://no.wikipedia.org/wiki/Adresse_(geografisk). Note
 * that the AddressAdditionalName also represents a place name ("stedsnavn") in Norwegian addresses when street names and numbers
 * are not used.
 */
@EqualsAndHashCode
@ToString
@Getter
public final class StreetAddress implements ValueObject {

    private final AddressName name;

    private final AddressNumber number;

    private final AddressAdditionalName additionalName;

    private final PropertyUnitNumber propertyUnitNumber;

    public StreetAddress(AddressAdditionalName additionalName) {
        this(null, null, additionalName, null);
    }

    public StreetAddress(AddressName name, AddressNumber number) {
        this(name, number, null, null);
    }

    public StreetAddress(
        AddressName name,
        AddressNumber number,
        AddressAdditionalName additionalName,
        PropertyUnitNumber propertyUnitNumber
    ) {
        this.name = name;
        this.number = number;
        this.additionalName = additionalName;
        this.propertyUnitNumber = propertyUnitNumber;
    }

    public String toLine() {
        StringBuilder line = new StringBuilder();

        if (additionalName != null) {
            line.append(additionalName.toPrimitive());
        }

        if (name != null) {
            if (!line.isEmpty()) {
                line.append(SPACE);
            }
            line.append(name.toPrimitive());
        }

        if (number != null) {
            if (!line.isEmpty()) {
                line.append(SPACE);
            }
            line.append(number.toPrimitive());
        }

        if (propertyUnitNumber != null) {
            if (!line.isEmpty()) {
                line.append(SPACE);
            }
            line.append(propertyUnitNumber.toPrimitive());
        }

        return line.toString();
    }

}
