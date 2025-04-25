package kr.mooner510.dsmpractice.global.security.auth

import kr.mooner510.dsmpractice.domain.user.entity.User
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.userdetails.UserDetails

class AuthDetails(
    private val user: User
) : UserDetails {
    override fun getAuthorities(): Collection<GrantedAuthority>? = null
    override fun getPassword(): String = user.password
    override fun getUsername(): String = user.accountId
    override fun isAccountNonExpired(): Boolean = true
    override fun isAccountNonLocked(): Boolean = true
    override fun isCredentialsNonExpired(): Boolean = true
    override fun isEnabled(): Boolean = true
}
