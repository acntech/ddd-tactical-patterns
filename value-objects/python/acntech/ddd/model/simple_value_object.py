from acntech.ddd.model.value_object import ValueObject
from acntech.ddd.utils.lang.comparable import Comparable


class SimpleValueObject(ValueObject, Comparable):
    """
    Represents a simple value object, which is an object that has a single underlying value, most often a primitive.

    :param value: The value of the object.
    :type value: Any
    """

    def __init__(self, value):
        self._val = value

    def unwrap(self):
        return self._val

    def __eq__(self, other):  # Equal to (`==`)
        if not isinstance(other, SimpleValueObject):
            return NotImplemented
        return self.unwrap() == other.unwrap()

    def __ne__(self, other):  # Not equal to (`!=`)
        return not self.__eq__(other)

    def __lt__(self, other):  # Less than (`<`)
        if not isinstance(other, SimpleValueObject):
            return NotImplemented
        return self.unwrap() < other.unwrap()

    def __gt__(self, other):  # Greater than (`>`)
        if not isinstance(other, SimpleValueObject):
            return NotImplemented
        return self.unwrap() > other.unwrap()

    def __le__(self, other):  # Less than or equal to (`<=`)
        if not isinstance(other, SimpleValueObject):
            return NotImplemented
        return self.unwrap() <= other.unwrap()

    def __ge__(self, other):  # Greater than or equal to (`>=`)
        if not isinstance(other, SimpleValueObject):
            return NotImplemented
        return self.unwrap() >= other.unwrap()

    def __str__(self):
        return str(self.unwrap())

    def __hash__(self):
        return hash(self.unwrap())

    def __repr__(self):
        return f'{type(self).__name__}({self.unwrap()!r})'
