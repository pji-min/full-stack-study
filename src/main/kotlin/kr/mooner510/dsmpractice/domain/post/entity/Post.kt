package kr.mooner510.dsmpractice.domain.post.entity

import jakarta.persistence.*
import jakarta.validation.constraints.NotBlank
import java.time.LocalDateTime

@Entity
class Post(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long = 0,

    @Column(nullable = false)
    @NotBlank(message = "제목은 필수입니다")
    var title: String,

    @Column(nullable = false)
    @NotBlank(message = "내용은 필수입니다")
    var content: String,

    @Column(nullable = false)
    var viewCount: Int = 0,

    @Column(nullable = false)
    var likeCount: Int = 0,

    @Column(nullable = false)
    var createdAt: LocalDateTime = LocalDateTime.now(),

    @Column(nullable = false)
    var updatedAt: LocalDateTime = LocalDateTime.now()
) {
    @PrePersist
    fun prePersist() {
        val currentTime = LocalDateTime.now()
        createdAt = currentTime
        updatedAt = currentTime
    }

    @PreUpdate
    fun preUpdate() {
        updatedAt = LocalDateTime.now()
    }

    // 이미지, author, 카테고리 기능 추후에 추가
}
