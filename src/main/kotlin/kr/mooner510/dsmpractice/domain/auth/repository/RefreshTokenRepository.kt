package kr.mooner510.dsmpractice.domain.auth.repository

import kr.mooner510.dsmpractice.domain.auth.entity.RefreshToken
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface RefreshTokenRepository : JpaRepository<RefreshToken, String> {
}
