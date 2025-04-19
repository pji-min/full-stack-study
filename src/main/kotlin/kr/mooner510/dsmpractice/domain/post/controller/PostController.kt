package kr.mooner510.dsmpractice.domain.post.controller

import kr.mooner510.dsmpractice.domain.post.dto.request.PostRequest
import kr.mooner510.dsmpractice.domain.post.dto.response.PostResponse
import kr.mooner510.dsmpractice.domain.post.service.PostService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/post")
class PostController (
    private val postService: PostService
){
    @PostMapping
    fun create(@RequestBody request: PostRequest): ResponseEntity<PostResponse> {
        val postResponse = postService.create(request)
        return ResponseEntity(postResponse, HttpStatus.CREATED)
    }

    @PutMapping("/{postId}")
    fun update(@PathVariable postId: Long, @RequestBody request: PostRequest): ResponseEntity<PostResponse> {
        val postResponse = postService.update(request, postId)
        return ResponseEntity(postResponse, HttpStatus.OK)
    }

    @GetMapping("/{postId}")
    fun getPost(@PathVariable postId: Long): ResponseEntity<PostResponse> {
        val postResponse = postService.getPost(postId)

        return ResponseEntity(postResponse, HttpStatus.OK)
    }

    @DeleteMapping("/{postId}")
    fun delete(@PathVariable postId: Long) {
        val postResponse = postService.delete(postId)
    }

    //getAllPost도 구현해야함
}
