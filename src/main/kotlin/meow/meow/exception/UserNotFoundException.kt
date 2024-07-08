package meow.meow.exception

class UserNotFoundException(
    val userId: Long? = null,
    message: String? = null
) : RuntimeException(message) {

}
