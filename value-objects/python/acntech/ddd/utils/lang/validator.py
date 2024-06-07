from abc import ABC, abstractmethod
from typing import Any


class Validator(ABC):

    @abstractmethod
    def validate(self, value: Any) -> None:
        """Validates the given object, raising a ValidationException if it is invalid."""
        pass
