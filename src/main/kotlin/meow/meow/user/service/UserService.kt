package meow.meow.user.service

import meow.meow.exception.UserNotFoundException
import meow.meow.global.exception.ErrorCode
import meow.meow.user.controller.request.CreateUserRequest
import meow.meow.user.controller.response.UserResponse
import meow.meow.user.domain.OAuthType
import meow.meow.user.domain.User
import meow.meow.user.repository.UserRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional(readOnly = true)
class UserService(
    private val userRepository: UserRepository
) {

    fun findUser(id: Long): UserResponse {
        val user = userRepository.findById(id)
            .orElseThrow {
                UserNotFoundException(
                    userId = id,
                    errorCode = ErrorCode.USER_NOT_FOUND,
                    "유저 진짜로 못찾음"
                )
            }
        return UserResponse(user.id, user.nickname, user.createdAt, user.modifiedAt)
    }

    @Transactional
    fun signupUser(request: CreateUserRequest): UserResponse {
        val user = userRepository.save(createUser(request))
        return UserResponse(user.id, user.nickname, user.createdAt, user.modifiedAt)
    }

    private fun createUser(request: CreateUserRequest): User {
        val newUser = User.create(
            email = request.email,
            nickname = request.nickname,
            oauthType = OAuthType.KAKAO
        )
        return userRepository.save(newUser);
    }
}
