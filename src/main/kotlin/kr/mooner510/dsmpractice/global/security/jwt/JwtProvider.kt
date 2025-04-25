package kr.mooner510.dsmpractice.global.security.jwt

import io.jsonwebtoken.Claims
import io.jsonwebtoken.Jwts
import io.jsonwebtoken.SignatureAlgorithm
import jakarta.servlet.http.HttpServletRequest
import kr.mooner510.dsmpractice.domain.auth.entity.RefreshToken
import kr.mooner510.dsmpractice.domain.auth.repository.RefreshTokenRepository
import kr.mooner510.dsmpractice.global.exception.JwtException
import kr.mooner510.dsmpractice.global.security.auth.AuthDetailsService
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.Authentication
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.stereotype.Component
import javax.crypto.spec.SecretKeySpec
import java.util.Date

@Component
class JwtProvider(
    private val jwtProperties: JwtProperties,
    private val authDetailsService: AuthDetailsService,
    private val refreshTokenRepository: RefreshTokenRepository
) {

    private val secretKeySpec: SecretKeySpec = SecretKeySpec(jwtProperties.secretKey.toByteArray(), SignatureAlgorithm.HS256.jcaName)

    fun generateToken(accountId: String, type: String, exp: Long): String {
        return Jwts.builder()
            .signWith(secretKeySpec)
            .setSubject(accountId)
            .setHeaderParam("type", type)
            .setIssuedAt(Date())
            .setExpiration(Date(System.currentTimeMillis() + exp * 1000))
            .compact()
    }

    fun generateAccessToken(accountId: String): String {
        return generateToken(accountId, "access", jwtProperties.accessExp)
    }

    fun generateRefreshToken(accountId: String): String {
        val refreshToken = generateToken(accountId, "refresh", jwtProperties.refreshExp)

        refreshTokenRepository.save(
            RefreshToken(accountId = accountId, refreshToken = refreshToken, ttl = jwtProperties.refreshExp)
        )

        return refreshToken
    }

    fun parseToken(bearerToken: String?): String? {
        return if (bearerToken != null && bearerToken.startsWith(jwtProperties.prefix)) {
            bearerToken.replace(jwtProperties.prefix, "").trim()
        } else {
            null
        }
    }

    fun resolveToken(request: HttpServletRequest): String? {
        val bearerToken = request.getHeader(jwtProperties.header)
        return parseToken(bearerToken)
    }

    private fun getTokenBody(token: String): Claims {
        return try {
            Jwts.parser()
                .setSigningKey(secretKeySpec)
                .parseClaimsJws(token)
                .body
        } catch (e: io.jsonwebtoken.ExpiredJwtException) {
            throw JwtException.ExpiredJwtException.EXCEPTION
        } catch (e: Exception) {
            throw JwtException.InvalidJwtException.EXCEPTION
        }
    }


    private fun getTokenSubject(token: String): String {
        return getTokenBody(token).subject
    }

    fun authentication(token: String): Authentication {
        val userDetails: UserDetails = authDetailsService.loadUserByUsername(getTokenSubject(token))
        return UsernamePasswordAuthenticationToken(userDetails, "", userDetails.authorities)
    }
}
