package kr.mooner510.dsmpractice.global.error

import kr.mooner510.dsmpractice.global.error.exception.CustomException
import kr.mooner510.dsmpractice.global.error.exception.ErrorCode
import kr.mooner510.dsmpractice.global.error.exception.ErrorResponse
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.validation.BindException
import org.springframework.validation.FieldError
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice

@RestControllerAdvice
class GlobalExceptionHandler {

    @ExceptionHandler(CustomException::class)
    fun handleCustomException(e: CustomException): ResponseEntity<ErrorResponse> {
        val errorCode: ErrorCode = e.errorCode
        val errorResponse = ErrorResponse(
            status = errorCode.status,
            message = errorCode.message
        )
        return ResponseEntity(errorResponse, errorCode.status)
    }

    @ExceptionHandler(BindException::class)
    fun handleBindException(e: BindException): ResponseEntity<Map<String, String>> {
        val errors = mutableMapOf<String, String>()
        e.fieldErrors.forEach { fieldError: FieldError ->
            errors[fieldError.field] = fieldError.defaultMessage ?: "Invalid value"
        }
        return ResponseEntity(errors, HttpStatus.BAD_REQUEST)
    }
}
