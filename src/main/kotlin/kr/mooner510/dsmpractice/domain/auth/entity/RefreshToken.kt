package kr.mooner510.dsmpractice.domain.auth.entity

import org.springframework.data.annotation.Id
import org.springframework.data.redis.core.RedisHash
import org.springframework.data.redis.core.TimeToLive
import org.springframework.data.redis.core.index.Indexed

@RedisHash("RefreshToken")
data class RefreshToken(

    @Id
    val accountId: String,

    @Indexed
    val refreshToken: String,

    @TimeToLive
    val ttl: Long
)
