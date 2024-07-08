package meow.meow.global.exception

import io.swagger.v3.oas.annotations.media.Schema

data class ErrorResponseModel(
    @Schema(description = "상세 메시지", example = "oauth exception")
    val message: String,

    @Schema(description = "상세 메시지")
    val detail: String,

    @Schema(description = "오류 아이디", example = "1")
    val errorCode: Int
)
