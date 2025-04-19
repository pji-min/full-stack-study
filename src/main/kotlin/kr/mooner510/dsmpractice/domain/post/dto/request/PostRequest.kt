package kr.mooner510.dsmpractice.domain.post.dto.request

import jakarta.validation.constraints.NotBlank
import kr.mooner510.dsmpractice.domain.post.entity.Post
import java.time.LocalDateTime

data class PostRequest (
    @NotBlank(message = "제목은 필수입니다")
    val title: String,

    @NotBlank(message = "내용은 필수입니다")
    val content: String,

    //author, 사진, 카테고리 추후에 추가
) {
    fun toEntity(): Post {
        return Post(
            title = this.title,
            content = this.content,
            viewCount = 0,
            likeCount = 0,
            createdAt = LocalDateTime.now(),
            updatedAt = LocalDateTime.now()
        )
    }

}
