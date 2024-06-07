def require(condition: bool, message: str = None, **kwargs):
    """
    Checks if the given condition is True, otherwise raises a ValueError with the given message.
    """
    if not condition:
        if message is None:
            message = "Requirement failed"
        else:
            # Use kwargs to format the message
            message = message.format(**kwargs)
        raise ValueError(message)
