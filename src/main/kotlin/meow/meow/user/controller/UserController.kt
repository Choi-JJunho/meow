package meow.meow.user.controller

import meow.meow.user.controller.response.UserResponse
import meow.meow.user.service.UserService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RestController
import java.net.URI

@RestController
class UserController(
    private val userService: UserService
) {
    @GetMapping("/user/test")
    fun getUser(): ResponseEntity<UserResponse> {
        return ResponseEntity.ok(UserResponse(1, "최준호"))
    }

    @PostMapping("/user/test")
    fun createUser(): ResponseEntity<Unit> {
        val (id) = userService.findUser()
        return ResponseEntity.created(URI("/user/${id}")).build()
    }
}
