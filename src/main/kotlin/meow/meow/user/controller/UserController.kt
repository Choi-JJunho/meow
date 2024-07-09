package meow.meow.user.controller

import jakarta.validation.Valid
import meow.meow.user.controller.request.CreateUserRequest
import meow.meow.user.controller.response.UserResponse
import meow.meow.user.service.UserService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RestController
import java.net.URI

@RestController
class UserController(
    private val userService: UserService
) {
    @GetMapping("/user/{id}")
    fun getUser(
        @PathVariable id: Long
    ): ResponseEntity<UserResponse> {
        val response = userService.findUser(id)
        return ResponseEntity.ok(response)
    }

    @PostMapping("/user")
    fun createUser(
        @Valid createUserRequest: CreateUserRequest
    ): ResponseEntity<Unit> {
        val (id) = userService.signupUser(createUserRequest)
        return ResponseEntity.created(URI("/user/${id}")).build()
    }
}
