from acntech.ddd.model.simple_value_object import SimpleValueObject
from acntech.ddd.model.simple_value_object_validator import SimpleValueObjectValidator
from acntech.ddd.model.validation_range import ValidationRange


class Temperature(SimpleValueObject):
    MIN_VALUE: float = 0.0
    MAX_VALUE: float = 1.0
    NORMAL = None
    MIN = None
    MAX = None
    _validator = SimpleValueObjectValidator(ValidationRange(inclusive_min=MIN_VALUE, inclusive_max=MAX_VALUE))

    @classmethod
    def of(cls, value):
        try:
            float_value = float(value)
        except ValueError:
            raise TypeError("Temperature value must be a float or a string that can be converted to a float.")
        return cls(float_value)

    def __init__(self, value):
        super().__init__(value)
        Temperature._validator.validate(self)


Temperature.MIN = Temperature(0.0)
Temperature.NORMAL = Temperature(0.7)
Temperature.MAX = Temperature(1.0)
