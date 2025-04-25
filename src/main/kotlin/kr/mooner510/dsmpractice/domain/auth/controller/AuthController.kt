package kr.mooner510.dsmpractice.domain.auth.controller

import jakarta.validation.Valid
import kr.mooner510.dsmpractice.domain.auth.dto.request.LoginRequest
import kr.mooner510.dsmpractice.domain.auth.dto.request.SignupRequest
import kr.mooner510.dsmpractice.domain.auth.dto.response.TokenResponse
import kr.mooner510.dsmpractice.domain.auth.service.LoginService
import kr.mooner510.dsmpractice.domain.auth.service.SignupService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/auth")
class AuthController(
    private val signupService: SignupService,
    private val loginService: LoginService
) {

    @PostMapping("/signup")
    @ResponseStatus(HttpStatus.CREATED)
    fun signUp(@RequestBody @Valid request: SignupRequest) {
        signupService.signup(request)
    }

    @PostMapping("/login")
    fun login(@RequestBody @Valid request: LoginRequest): TokenResponse {
        return loginService.login(request)
    }
}
