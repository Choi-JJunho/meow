package meow.meow.user.domain

import jakarta.persistence.*
import jakarta.persistence.EnumType.STRING
import jakarta.persistence.GenerationType.IDENTITY
import meow.meow.global.common.BaseEntity

@Entity
@Table(name = "users")
class User(
    @Id
    @GeneratedValue(strategy = IDENTITY)
    val id: Long = 0,
    var email: String,
    var phoneNumber: String? = null,
    var nickname: String? = null,
    @Enumerated(STRING) var oauthType: OAuthType,
    var imagePath: String? = null
) : BaseEntity() {

    companion object {
        fun create(
            email: String,
            phoneNumber: String? = null,
            nickname: String? = null,
            oauthType: OAuthType,
            imagePath: String? = null
        ): User {
            return User(
                email = email,
                phoneNumber = phoneNumber,
                nickname = nickname,
                oauthType = oauthType,
                imagePath = imagePath
            )
        }
    }
}
