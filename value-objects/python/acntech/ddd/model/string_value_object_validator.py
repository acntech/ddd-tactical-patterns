from acntech.ddd.model.simple_value_object_validator import SimpleValueObjectValidator
from acntech.ddd.model.validation_range import ValidationRange
from acntech.ddd.utils.lang.validation_exception import ValidationException
from acntech.ddd.utils.lang.validator import Validator


class StringValueObjectValidator(SimpleValueObjectValidator):
    def __init__(
        self,
        range_val=ValidationRange(),
        min_length=None,
        max_length=None,
        lexical_validator: Validator = None,
        syntax_validator: Validator = None,
        semantics_validator: Validator = None
    ):
        super().__init__(range_val)
        self._min_length = min_length
        self._max_length = max_length
        self._lexical_validator = lexical_validator
        self._syntax_validator = syntax_validator
        self._semantics_validator = semantics_validator

    def validate(self, t):
        super().validate(t)  # Call base class validation

        value = t.unwrap()

        # Length checks
        if self._min_length is not None and len(value) < self._min_length:
            raise ValidationException(
                f"String length {len(value)} below allowed minimum {self._min_length} for value {value}")

        if self._max_length is not None and len(value) > self._max_length:
            raise ValidationException(
                f"String length {len(value)} exceeds allowed "
                f"maximum {self._max_length} for value {value[:1024]}"
            )

        # Lexical content checks
        if self._lexical_validator is not None:
            self._lexical_validator.validate(value)

        # Syntax checks
        if self._syntax_validator is not None:
            self._syntax_validator.validate(value)

        # Semantics checks
        if self._semantics_validator is not None:
            self._semantics_validator.validate(value)

    def __str__(self):
        return f"StringValueObjectValidator({self._min_length!s}, {self._max_length!s}, " \
               f"{self._lexical_validator!r}, {self._syntax_validator!r}, {self._semantics_validator!r})"
