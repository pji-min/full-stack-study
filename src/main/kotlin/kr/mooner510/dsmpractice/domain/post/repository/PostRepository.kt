package kr.mooner510.dsmpractice.domain.post.repository

import kr.mooner510.dsmpractice.domain.post.entity.Post
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface PostRepository : JpaRepository<Post, Long> {
}
