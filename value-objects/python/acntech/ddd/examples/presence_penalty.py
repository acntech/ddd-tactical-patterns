from acntech.ddd.model.simple_value_object import SimpleValueObject
from acntech.ddd.model.simple_value_object_validator import SimpleValueObjectValidator
from acntech.ddd.model.validation_range import ValidationRange


class PresencePenalty(SimpleValueObject):
    """
    A class representing a presence penalty.

    The presence penalty represents the penalty for being absent or less present in a certain context.
    It is a floating-point value between 0.0 and 1.0, where 0.0 represents no penalty and 1.0 represents
    the maximum penalty.

    :param value: The value of the presence penalty.
    :type value: float

    :raises TypeError: If the value is not a float or a string that can be converted to a float.

    :ivar MIN_VALUE: The minimum value of the presence penalty.
    :vartype MIN_VALUE: float
    :ivar MAX_VALUE: The maximum value of the presence penalty.
    :vartype MAX_VALUE: float
    :ivar _validator: The validator for the presence penalty value.
    :vartype _validator: SimpleValueObjectValidator

    """
    MIN_VALUE: float = 0.0
    MAX_VALUE: float = 1.0
    NONE = None
    _validator = SimpleValueObjectValidator(ValidationRange(inclusive_min=MIN_VALUE, inclusive_max=MAX_VALUE))

    @classmethod
    def of(cls, value):
        try:
            float_value = float(value)
        except ValueError:
            raise TypeError("PresencePenalty value must be a float or a string that can be converted to a float.")
        return cls(float_value)

    def __init__(self, value):
        super().__init__(value)
        PresencePenalty._validator.validate(self)


PresencePenalty.NONE = PresencePenalty(0.0)
