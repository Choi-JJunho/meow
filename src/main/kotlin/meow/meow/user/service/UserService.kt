package meow.meow.user.service

import meow.meow.exception.UserNotFoundException
import meow.meow.user.controller.response.UserResponse
import meow.meow.user.repository.UserRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional
class UserService(
    private val userRepository: UserRepository
) {

    fun findUser(): UserResponse {
        val user = userRepository.findById(1)
            .orElseThrow { UserNotFoundException(1) }

        return UserResponse(
            id = user.id,
            nickname = user.nickname
        )
    }
}
