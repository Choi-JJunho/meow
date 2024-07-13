package pomonyang.pomonyang.user.service

import pomonyang.pomonyang.exception.UserNotFoundException
import pomonyang.pomonyang.global.exception.ErrorCode
import pomonyang.pomonyang.user.controller.request.CreateUserRequest
import pomonyang.pomonyang.user.controller.response.UserResponse
import pomonyang.pomonyang.user.domain.OAuthType
import pomonyang.pomonyang.user.domain.User
import pomonyang.pomonyang.user.repository.UserRepository
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
