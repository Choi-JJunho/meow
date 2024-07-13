package pomonyang.pomonyang.exception

import pomonyang.pomonyang.global.exception.ErrorCode
import pomonyang.util.ErrorUtils
import pomonyang.util.createErrorTraceId

/**
 * 프로젝트에 사용되는 비즈니스 로직에 대한 예외는 해당 Exception을 상속받는다.
 */
abstract class PomoNyangException(
    val errorCode: ErrorCode,
    val errorTraceId: String = ErrorUtils.createErrorTraceId(),
    override val message: String
) : RuntimeException(message)
