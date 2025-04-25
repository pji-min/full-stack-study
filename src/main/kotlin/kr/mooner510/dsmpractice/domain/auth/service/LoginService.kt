package kr.mooner510.dsmpractice.domain.auth.service

import jdk.jshell.spi.ExecutionControl.UserException
import kr.mooner510.dsmpractice.domain.auth.dto.request.LoginRequest
import kr.mooner510.dsmpractice.domain.auth.dto.response.TokenResponse
import kr.mooner510.dsmpractice.domain.auth.exception.AuthException
import kr.mooner510.dsmpractice.domain.user.exception.UserNotFoundException
import kr.mooner510.dsmpractice.domain.user.repository.UserRepository
import kr.mooner510.dsmpractice.global.security.jwt.JwtProperties
import kr.mooner510.dsmpractice.global.security.jwt.JwtProvider
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.time.ZoneId
import java.time.ZonedDateTime

@Service
class LoginService(
    private val userRepository: UserRepository,
    private val passwordEncoder: PasswordEncoder,
    private val jwtTokenProvider: JwtProvider,
    private val jwtProperties: JwtProperties
) {

    @Transactional(readOnly = true)
    fun login(request: LoginRequest): TokenResponse {
        val user = userRepository.findByAccountId(request.accountId)
            ?: throw UserNotFoundException

        if (!passwordEncoder.matches(request.password, user.password)) {
            throw AuthException.PasswordMisMatchException.EXCEPTION
        }

        val now = ZonedDateTime.now(ZoneId.of("Asia/Seoul"))

        return TokenResponse(
            accessToken = jwtTokenProvider.generateAccessToken(request.accountId),
            accessExpiredAt = now.plusSeconds(jwtProperties.accessExp),
            refreshToken = jwtTokenProvider.generateRefreshToken(request.accountId),
            refreshExpiredAt = now.plusSeconds(jwtProperties.refreshExp)
        )
    }
}