package kr.mooner510.dsmpractice.domain.post.service

import jakarta.transaction.Transactional
import kr.mooner510.dsmpractice.domain.post.dto.request.PostRequest
import kr.mooner510.dsmpractice.domain.post.dto.response.PostResponse
import kr.mooner510.dsmpractice.domain.post.repository.PostRepository
import org.springframework.stereotype.Service
import java.time.LocalDateTime

@Service
class PostService(
    private val postRepository: PostRepository
) {
    @Transactional
    fun create(request: PostRequest): PostResponse {
        val post = request.toEntity()
        val savedPost = postRepository.save(post)
        return PostResponse.from(savedPost)
    }

    @Transactional
    fun update(request: PostRequest, postId: Long): PostResponse {
        val post = postRepository.findById(postId)
            .orElseThrow { IllegalArgumentException("해당 ID의 게시글이 없습니다") }

        post.title = request.title
        post.content = request.content
        post.updatedAt = LocalDateTime.now()

        val updatedPost = postRepository.save(post)
        return PostResponse.from(updatedPost)
    }

    @Transactional
    fun delete(postId: Long) {
        val post = postRepository.findById(postId)
            .orElseThrow { IllegalArgumentException("해당 ID의 게시글이 없습니다") }

        postRepository.delete(post)
    }

    @Transactional
    fun getPost(postId: Long): PostResponse {
        val post = postRepository.findById(postId)
            .orElseThrow { IllegalArgumentException("해당 ID의 게시글이 없습니다") }
        return PostResponse.from(post)
    }
}
