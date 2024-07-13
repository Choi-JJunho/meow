package pomonyang.pomonyang.global.exception

import io.swagger.v3.oas.annotations.media.Schema

data class ErrorResponse(
    @Schema(description = "에러 메시지", example = "사용자가 존재하지 않습니다.")
    override val message: String,
    @Schema(description = "상세 메시지", example = "사용자가 존재하지 않습니다.")
    override val detail: String,
    @Schema(description = "errorTraceId", example = "오류 추적에 활용되는 id")
    override val errorTraceId: String
) : ErrorDetails
