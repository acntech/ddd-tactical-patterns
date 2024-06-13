package no.acntech.ddd.examples.address;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NonNull;
import lombok.ToString;

/**
 * Class representing a Norwegian postal box address.
 */
@Getter
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public final class PostalBoxAddress extends PostalAddress {

    private final PostOfficeBox postOfficeBox;

    public PostalBoxAddress(
        @NonNull Addressee addressee,
        @NonNull PostOfficeBox postOfficeBox,
        @NonNull PostCode postCode,
        @NonNull PostCodeArea postCodeArea
    ) {
        super(addressee, postCode, postCodeArea);
        this.postOfficeBox = postOfficeBox;
    }

}
