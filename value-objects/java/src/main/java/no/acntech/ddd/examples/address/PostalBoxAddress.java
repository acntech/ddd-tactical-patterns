package no.acntech.ddd.examples.address;

import static no.acntech.ddd.utils.text.StringLiterals.SPACE;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NonNull;
import lombok.ToString;

/**
 * Class representing a Norwegian <i>postal box address</i>.
 */
@Getter
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public final class PostalBoxAddress extends PostalAddress {

    public static final String NO_POST_BOX = "Postboks";

    public static final String EN_POST_BOX = "P.O.Box";

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

    public String toSecondLine() {
        return NO_POST_BOX + SPACE + postOfficeBox.toPrimitive();
    }

}
