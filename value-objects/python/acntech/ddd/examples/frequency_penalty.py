from acntech.ddd.model.simple_value_object import SimpleValueObject
from acntech.ddd.model.simple_value_object_validator import SimpleValueObjectValidator
from acntech.ddd.model.validation_range import ValidationRange


class FrequencyPenalty(SimpleValueObject):
    """
    Represents a frequency penalty.

    Valid values are floats between 0.0 and 1.0 (inclusive).

    Penalizes words that are often used in the language model's training data.
    A high frequency penalty makes the model avoid using common words, giving preference to rare or unique ones that
    were less frequently observed in the training data. Conversely, a low frequency penalty will make the model more
    likely to use common words or phrases.

    :param value: The frequency penalty value.
    :type value: float

    :raises TypeError: If the provided value is not a float or a string that can be converted to a float.
    """
    MIN_VALUE: float = 0.0
    MAX_VALUE: float = 1.0
    _validator = SimpleValueObjectValidator(ValidationRange(inclusive_min=MIN_VALUE, inclusive_max=MAX_VALUE))
    NONE = None  # declare NONE here

    @classmethod
    def of(cls, value):
        """
        Create a FrequencyPenalty object from a given value.

        :param value: The value of the FrequencyPenalty as a float or a string that can be converted to a float.
        :type value: float or str
        :return: A FrequencyPenalty object with the specified value.
        :rtype: FrequencyPenalty
        :raises TypeError: If the value cannot be converted to a float.
        """
        try:
            float_value = float(value)
        except ValueError:
            raise TypeError("FrequencyPenalty value must be a float or a string that can be converted to a float.")
        return cls(float_value)

    def __init__(self, value):
        super().__init__(value)
        FrequencyPenalty._validator.validate(self)


FrequencyPenalty.NONE = FrequencyPenalty(0.0)
