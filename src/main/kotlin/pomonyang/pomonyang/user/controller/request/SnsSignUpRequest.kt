package pomonyang.pomonyang.user.controller.request

import io.swagger.v3.oas.annotations.media.Schema
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.NotNull
import pomonyang.pomonyang.user.domain.OAuthType

data class SnsSignUpRequest(
    @Schema
    val nickname: String,
    val email: String,
    val phoneNumber: String,
    @NotNull val oauthType: OAuthType,
    @NotBlank val oauthIdentity: String,
    val imagePath: String,
) {
}
