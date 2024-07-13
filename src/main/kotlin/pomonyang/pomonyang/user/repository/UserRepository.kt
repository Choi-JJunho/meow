package pomonyang.pomonyang.user.repository

import pomonyang.pomonyang.user.domain.User
import org.springframework.data.jpa.repository.JpaRepository

interface UserRepository : JpaRepository<User, Long>
