package kr.mooner510.dsmpractice.domain.user.entity

import jakarta.persistence.*

@Entity
@Table(name = "tbl_user")
data class User (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    @Column(unique = true, nullable = false)
    var accountId: String,

    @Column(nullable = false)
    var email: String,

    @Column(nullable = false)
    var username: String,

    @Column(nullable = false)
    var password: String,
)