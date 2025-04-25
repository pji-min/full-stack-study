package kr.mooner510.dsmpractice.global.error.exception

import org.springframework.http.HttpStatus

data class ErrorResponse(
    val status: HttpStatus,
    val message: String,
)
