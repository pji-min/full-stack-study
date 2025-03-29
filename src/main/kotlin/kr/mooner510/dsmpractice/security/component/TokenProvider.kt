package kr.mooner510.dsmpractice.security.component

import io.jsonwebtoken.ExpiredJwtException
import io.jsonwebtoken.Jwts
import io.jsonwebtoken.UnsupportedJwtException
import io.jsonwebtoken.security.Keys
import kr.mooner510.dsmpractice.global.error.ErrorCode
import kr.mooner510.dsmpractice.global.error.data.GlobalError
import kr.mooner510.dsmpractice.security.data.entity.user.User
import org.springframework.stereotype.Component
import java.util.*

@Component
class TokenProvider(
) {
    private val key = Keys.hmacShaKeyFor(keyString.toByteArray())
    private val parser = Jwts.parser().verifyWith(key).build()

    fun newAccess(user: User): String {
        throw NotImplementedError()
    }

    fun newRefresh(user: User): String {
        throw NotImplementedError()
    }

    fun getUser(token: String, isAccessToken: Boolean): User {
        try {
            throw NotImplementedError()
        } catch (e: Exception) {
            e.printStackTrace()
            if (e is UnsupportedJwtException) {
                throw GlobalError(ErrorCode.UNSUPPORTED_TOKEN)
            } else if (e is ExpiredJwtException) {
                throw GlobalError(ErrorCode.EXPIRED_TOKEN)
            }
            throw e
        }
    }
}
