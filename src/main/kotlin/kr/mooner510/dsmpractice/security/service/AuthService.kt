package kr.mooner510.dsmpractice.security.service

import kr.mooner510.dsmpractice.security.data.response.TokenResponse
import kr.mooner510.dsmpractice.security.data.response.TokenResponseAccessOnly
import org.springframework.stereotype.Service
import java.util.*

@Service
class AuthService {
    fun login(req: LoginRequest): TokenResponse {
        throw NotImplementedError()
    }

    fun signUp(req: LoginRequest) {
        throw NotImplementedError()
    }

    fun reissue(req: ReissueRequest): TokenResponseAccessOnly {
        throw NotImplementedError()
    }
}
