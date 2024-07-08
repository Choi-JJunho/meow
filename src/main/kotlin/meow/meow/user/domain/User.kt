package meow.meow.user.domain

import jakarta.persistence.Entity
import jakarta.persistence.EnumType.STRING
import jakarta.persistence.Enumerated
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType.IDENTITY
import jakarta.persistence.Id

@Entity
class User(
    @Id
    @GeneratedValue(strategy = IDENTITY)
    val id: Long,
    val email: String,
    val phoneNumber: String?,
    var nickname: String?,
    @Enumerated(STRING)
    val oauthType: OAuthType,
    val imageUrl: String? = null
) {


}
