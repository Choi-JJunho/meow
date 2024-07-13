package pomonyang.pomonyang.user.controller

import jakarta.validation.Valid
import pomonyang.pomonyang.user.controller.request.CreateUserRequest
import pomonyang.pomonyang.user.controller.response.UserResponse
import pomonyang.pomonyang.user.service.UserService
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

    /*
물론, 각 명령어와 간단한 사용법을 정리해 드리겠습니다.

---
물론, 옵션을 제외하고 명령어만 간단히 정리해 드리겠습니다.

---


---

이렇게 각 명령어만 간단히 정리해 보았습니다. 도움이 되길 바랍니다!

---

이렇게 각 명령어와 간단한 사용법을 정리해 보았습니다. 도움이 되길 바랍니다!
    
    












     */
    @PostMapping("/user")
    fun createUser(
        @Valid createUserRequest: CreateUserRequest
    ): ResponseEntity<Unit> {
        val (id) = userService.signupUser(createUserRequest)
        return ResponseEntity.created(URI("/user/${id}")).build()
    }
}
