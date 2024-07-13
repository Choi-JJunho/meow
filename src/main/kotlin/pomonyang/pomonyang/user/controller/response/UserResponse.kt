package pomonyang.pomonyang.user.controller.response

import com.fasterxml.jackson.annotation.JsonFormat
import java.time.LocalDateTime

data class UserResponse(
    val id: Long,
    val nickname: String?,
    @JsonFormat(pattern = "yyyy-MM-dd")
    val cratedAt: LocalDateTime?,
    @JsonFormat(pattern = "yyyy-MM-dd")
    val updatedAt: LocalDateTime?
)
