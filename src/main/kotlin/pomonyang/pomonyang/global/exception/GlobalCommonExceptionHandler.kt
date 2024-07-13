package pomonyang.pomonyang.global.exception

import pomonyang.util.ErrorUtils
import pomonyang.util.createErrorTraceId
import pomonyang.util.logger
import org.springframework.http.ResponseEntity
import org.springframework.validation.FieldError
import org.springframework.validation.ObjectError
import org.springframework.web.bind.MethodArgumentNotValidException
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice


@RestControllerAdvice
class GlobalCommonExceptionHandler {
    val log = logger()

    @ExceptionHandler
    fun handleMethodArgumentNotValidException(ex: MethodArgumentNotValidException): ResponseEntity<InvalidArgsErrorDetails> {
        val fieldErrors: List<FieldError> = ex.bindingResult.allErrors.stream()
            .filter { it: ObjectError? -> it is FieldError }
            .map<FieldError> { it: ObjectError? -> (it as FieldError?) }
            .toList()
        val errorTraceId = ErrorUtils.createErrorTraceId()
        log.info(
            "handleMethodArgumentNotValidException. errorTraceId: {}, fieldErrors: {}",
            errorTraceId,
            fieldErrors,
            ex
        )
        val fields: List<String> = fieldErrors.stream().map { obj: FieldError -> obj.field }.toList()
        return ResponseEntity
            .status(ErrorCode.INVALID_ARGS.statusCode)
            .body(
                InvalidArgsErrorDetails(
                    message = ErrorCode.INVALID_ARGS.defaultMessage,
                    errorTraceId = errorTraceId,
                    violations = fields
                )
            )
    }
}
