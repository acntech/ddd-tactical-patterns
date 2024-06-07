import re
from dataclasses import dataclass

from acntech.ddd.utils.lang.functions import require
from acntech.ddd.utils.lang.validation_exception import ValidationException
from acntech.ddd.utils.lang.validator import Validator


@dataclass
class RegexValidator(Validator):
    """
    Validator that checks if a string matches a given regex pattern.

    Args:
        pattern (str): The regex pattern to match against.

    Attributes:
        _pattern (re.Pattern): The compiled regex pattern.

    Methods:
        validate(value): Validates if the given value matches the regex pattern.
        __eq__(other): Checks if two RegexValidators are equal.
        __hash__(): Computes the hash value of the RegexValidator.
        __str__(): Returns the regex pattern as a string.

    """

    def __init__(self, pattern: str):
        require(pattern is not None, "Pattern must be a non-empty string")
        self._pattern: re.Pattern = re.compile(pattern)

    def validate(self, value):
        if not self._pattern.match(value):
            raise ValidationException(
                f"String '{value}' does not match the required regex pattern: {self._pattern.pattern}")
