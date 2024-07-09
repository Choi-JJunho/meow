package meow.meow.exception

import meow.meow.global.exception.ErrorCode

class UserNotFoundException(
    val userId: Long? = null,
    errorCode: ErrorCode,
    message: String
) : MeowException(errorCode = errorCode, message = message)
