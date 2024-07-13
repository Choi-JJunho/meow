package pomonyang.pomonyang.global.exception

import org.springframework.http.HttpStatus

/**
 * Client 측에서 에러 분기처리를 위해 사용할 에러 타입
 */
enum class ErrorCode(
    val defaultMessage: String,
    val statusCode: HttpStatus
) {
    USER_NOT_FOUND("사용자를 찾을 수 없습니다.", HttpStatus.NOT_FOUND),
    INVALID_ARGS("잘못된 요청입니다.", HttpStatus.BAD_REQUEST),
    ;
}
