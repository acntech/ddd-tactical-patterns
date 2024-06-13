package no.acntech.ddd.examples.address;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NonNull;
import lombok.ToString;
import no.acntech.ddd.model.ValueObject;

/**
 * Base Value object representing a Norwegian postal address - see https://no.wikipedia.org/wiki/Adresse_(geografisk). Subclasses
 * are PropertyAddress and PostalBoxAddress.
 */
@Getter
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public final class PostalPropertyAddress extends PostalAddress {

    private final StreetAddress streetAddress;

    public PostalPropertyAddress(
        @NonNull Addressee addressee,
        @NonNull StreetAddress streetAddress,
        @NonNull PostCode postCode,
        @NonNull PostCodeArea postCodeArea
    ) {
        super(addressee, postCode, postCodeArea);
        this.streetAddress = streetAddress;
    }

}
