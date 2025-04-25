package kr.mooner510.dsmpractice.domain.user.repository

import kr.mooner510.dsmpractice.domain.user.entity.User
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface UserRepository : JpaRepository<User, Long> {
    fun findByAccountId(accountId: String): User?
}
