class ValidationException(Exception):
    """Exception that is thrown when a validation error occurs."""

    def __init__(self, message=None):
        super().__init__(message)
