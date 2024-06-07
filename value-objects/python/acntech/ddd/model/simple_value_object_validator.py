from acntech.ddd.model.simple_value_object import SimpleValueObject
from acntech.ddd.model.validation_range import ValidationRange
from acntech.ddd.utils.lang.validation_exception import ValidationException
from acntech.ddd.utils.lang.validator import Validator


class SimpleValueObjectValidator(Validator):
    def __init__(self, range_val: ValidationRange):
        self._range = range_val

    def validate(self, t: SimpleValueObject):
        value = t.unwrap()

        if self._range.inclusive_min is not None and value < self._range.inclusive_min:
            raise ValidationException(f"Value '{value}' is below exclusive minimum {self._range.inclusive_min}")

        if self._range.exclusive_min is not None and value <= self._range.exclusive_min:
            raise ValidationException(f"Value '{value}' is below or at inclusive minimum {self._range.exclusive_min}")

        if self._range.inclusive_max is not None and value > self._range.inclusive_max:
            raise ValidationException(f"Value '{value}' is above exclusive maximum {self._range.inclusive_max}")

        if self._range.exclusive_max is not None and value >= self._range.exclusive_max:
            raise ValidationException(f"Value '{value}' is above or at inclusive maximum {self._range.exclusive_max}")
