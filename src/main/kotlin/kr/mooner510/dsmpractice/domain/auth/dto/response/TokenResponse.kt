package kr.mooner510.dsmpractice.domain.auth.dto.response

import java.time.ZonedDateTime

data class TokenResponse(
    val accessToken: String,
    val accessExpiredAt: ZonedDateTime,
    val refreshToken: String,
    val refreshExpiredAt: ZonedDateTime
)
