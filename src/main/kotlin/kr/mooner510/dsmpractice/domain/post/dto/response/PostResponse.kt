package kr.mooner510.dsmpractice.domain.post.dto.response

import kr.mooner510.dsmpractice.domain.post.entity.Post
import java.time.LocalDateTime

data class PostResponse(
    val id: Long,
    val title: String,
    val content: String,
    val viewCount: Int,
    val likeCount: Int,
    val createdAt: LocalDateTime,
    val updatedAt: LocalDateTime,

    //author, 사진, 카테고리 추후에 추가
) {
    companion object {
        fun from(post: Post): PostResponse {
            return PostResponse(
                id = post.id,
                title = post.title,
                content = post.content,
                viewCount = post.viewCount,
                likeCount = post.likeCount,
                createdAt = post.createdAt,
                updatedAt = post.updatedAt
            )
        }
    }
}
