package no.acntech.ddd.utils.lang

/**
 * Exception thrown when a validation error occurs.
 */
class ValidationException : RuntimeException {

   constructor() : super()

   constructor(message: String) : super(message)

   constructor(message: String, cause: Throwable) : super(message, cause)

   constructor(cause: Throwable) : super(cause)
}
