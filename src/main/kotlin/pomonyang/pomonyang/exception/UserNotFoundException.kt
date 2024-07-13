package pomonyang.pomonyang.exception

import pomonyang.pomonyang.global.exception.ErrorCode

class UserNotFoundException(
    val userId: Long? = null,
    errorCode: ErrorCode,
    message: String
) : PomoNyangException(errorCode = errorCode, message = message)
