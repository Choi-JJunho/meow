package meow.meow.exception

import meow.meow.global.exception.ErrorCode
import meow.util.ErrorUtils
import meow.util.createErrorTraceId

/**
 * 프로젝트에 사용되는 비즈니스 로직에 대한 예외는 MeowException을 상속받는다.
 */
abstract class MeowException(
    val errorCode: ErrorCode,
    val errorTraceId: String = ErrorUtils.createErrorTraceId(),
    override val message: String
) : RuntimeException(message)
