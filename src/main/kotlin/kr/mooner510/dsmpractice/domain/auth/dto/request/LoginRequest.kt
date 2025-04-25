package kr.mooner510.dsmpractice.domain.auth.dto.request

import jakarta.validation.constraints.Email
import jakarta.validation.constraints.NotBlank

data class LoginRequest(
    @NotBlank(message = "accountId는 필수 항목입니다.")
    val accountId: String,

    @NotBlank(message = "password는 필수 항목입니다.")
    val password: String
)
