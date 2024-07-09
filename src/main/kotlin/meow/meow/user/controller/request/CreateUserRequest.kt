package meow.meow.user.controller.request

import jakarta.validation.constraints.Email
import org.jetbrains.annotations.NotNull

data class CreateUserRequest(
    @NotNull val nickname: String,
    @NotNull @Email val email: String,
)
