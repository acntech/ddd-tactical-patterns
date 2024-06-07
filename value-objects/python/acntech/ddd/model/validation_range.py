from dataclasses import dataclass
from typing import Optional, Any

from acntech.ddd.utils.lang.functions import require


@dataclass
class ValidationRange:
    """Represents a range for validating a value.

    Args:
        inclusive_min: The inclusive minimum value of the range.
        exclusive_min: The exclusive minimum value of the range.
        inclusive_max: The inclusive maximum value of the range.
        exclusive_max: The exclusive maximum value of the range.
    """
    inclusive_min: Optional[Any] = None
    exclusive_min: Optional[Any] = None
    inclusive_max: Optional[Any] = None
    exclusive_max: Optional[Any] = None

    def __post_init__(self):
        require(not (self.inclusive_min is not None and self.exclusive_min is not None),
                "Both inclusive_min and exclusive_min are set. They are mutually exclusive.")
        require(not (self.inclusive_max is not None and self.exclusive_max is not None),
                "Both inclusive_max and exclusive_max are set. They are mutually exclusive.")
