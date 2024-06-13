package no.acntech.ddd.examples.address;

import static no.acntech.ddd.utils.text.StringLiterals.SPACE;

import lombok.Getter;
import lombok.NonNull;
import lombok.ToString;
import no.acntech.ddd.model.ValueObject;

/**
 * Base Value object representing a Norwegian postal address - see https://no.wikipedia.org/wiki/Adresse_(geografisk). Subclasses
 * are {@link PostalPropertyAddress} and {@link PostalBoxAddress}.
 */
@Getter
@ToString
public abstract class PostalAddress implements ValueObject {

    private final Addressee addressee;

    private final PostCode postCode;

    private final PostCodeArea postCodeArea;

    protected PostalAddress(
        @NonNull Addressee addressee,
        @NonNull PostCode postCode,
        @NonNull PostCodeArea postCodeArea
    ) {
        this.addressee = addressee;
        this.postCode = postCode;
        this.postCodeArea = postCodeArea;
    }

    public String toFirstLine() {
        return addressee.toPrimitive();
    }

    public abstract String toSecondLine();

    public String toThirdLine() {
        return postCode.toPrimitive() + SPACE + postCodeArea.toPrimitive();
    }

}
