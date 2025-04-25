package kr.mooner510.dsmpractice.domain.auth.dto.request

import jakarta.validation.constraints.Email
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.Size

data class SignupRequest(
    @NotBlank(message = "accountId는 필수 항목입니다.")
    val accountId: String,

    @NotBlank(message = "email은 필수 항목입니다.")
    @Email(message = "올바른 email 형식이 아닙니다.")
    val email: String,

    @NotBlank(message = "username는 필수 항목입니다.")
    val username: String,

    @NotBlank(message = "password는 필수 항목입니다.")
    @Size(min = 8, message = "password가 너무 짧습니다.(8자 이상)")
    val password: String
)
