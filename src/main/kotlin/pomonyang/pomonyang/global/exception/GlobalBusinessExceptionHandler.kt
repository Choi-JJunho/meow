package pomonyang.pomonyang.global.exception

import pomonyang.pomonyang.exception.UserNotFoundException
import pomonyang.util.logger
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice


@RestControllerAdvice
class GlobalBusinessExceptionHandler {
    val log = logger()

    @ExceptionHandler
    fun handleUserNotFoundException(ex: UserNotFoundException): ResponseEntity<ErrorResponse> {
        log.warn("handleUserNotFoundException. errorTraceId : ${ex.errorTraceId} message: ${ex.message}")
        return ResponseEntity
            .status(HttpStatus.BAD_REQUEST)
            .body(
                ErrorResponse(
                    message = ex.errorCode.defaultMessage,
                    detail = ex.message,
                    errorTraceId = ex.errorTraceId
                )
            )
    }
}
