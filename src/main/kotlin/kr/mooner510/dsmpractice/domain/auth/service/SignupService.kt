package kr.mooner510.dsmpractice.domain.auth.service

import kr.mooner510.dsmpractice.domain.auth.dto.request.SignupRequest
import kr.mooner510.dsmpractice.domain.user.entity.User
import kr.mooner510.dsmpractice.domain.user.exception.UserExistException
import kr.mooner510.dsmpractice.domain.user.repository.UserRepository
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class SignupService(
    private val userRepository: UserRepository,
    private val passwordEncoder: PasswordEncoder
) {

    @Transactional
    fun signup(request: SignupRequest) {
        if (userRepository.findByAccountId(request.accountId) != null) {
            throw UserExistException
        }

        val user = User(
            accountId = request.accountId,
            email = request.email,
            password = passwordEncoder.encode(request.password),
            username = request.username
        )

        userRepository.save(user)
    }
}
