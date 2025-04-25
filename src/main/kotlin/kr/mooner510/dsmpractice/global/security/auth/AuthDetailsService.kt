package kr.mooner510.dsmpractice.global.security.auth

import kr.mooner510.dsmpractice.domain.user.repository.UserRepository
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.stereotype.Service

@Service
class AuthDetailsService(
    private val userRepository: UserRepository
) : UserDetailsService {

    override fun loadUserByUsername(accountId: String): UserDetails {
        val user = userRepository.findByAccountId(accountId)
            ?: throw UsernameNotFoundException(accountId)
        return AuthDetails(user)
    }
}
