package kr.mooner510.dsmpractice.global.error

import com.fasterxml.jackson.databind.ObjectMapper
import kr.mooner510.dsmpractice.global.error.exception.CustomException
import kr.mooner510.dsmpractice.global.error.exception.ErrorCode
import kr.mooner510.dsmpractice.global.error.exception.ErrorResponse
import jakarta.servlet.FilterChain
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse
import org.slf4j.LoggerFactory
import org.springframework.http.MediaType
import org.springframework.web.filter.OncePerRequestFilter
import java.io.IOException

class ExceptionFilter(
    private val objectMapper: ObjectMapper
) : OncePerRequestFilter() {

    private val logger = LoggerFactory.getLogger(ExceptionFilter::class.java)

    @Throws(IOException::class)
    override fun doFilterInternal(
        request: HttpServletRequest,
        response: HttpServletResponse,
        filterChain: FilterChain
    ) {
        try {
            filterChain.doFilter(request, response)
        } catch (e: CustomException) {
            logger.error("Custom exception occurred: ", e)
            sendErrorMessage(response, e.errorCode)
        } catch (e: Exception) {
            logger.error("Unexpected error occurred: ", e)
            sendErrorMessage(response, ErrorCode.INTERNAL_SERVER_ERROR)
        }
    }

    @Throws(IOException::class)
    private fun sendErrorMessage(response: HttpServletResponse, errorCode: ErrorCode) {
        val errorResponse = ErrorResponse(
            status = errorCode.status,
            message = errorCode.message
        )

        response.status = errorCode.status.value()
        response.contentType = MediaType.APPLICATION_JSON_VALUE
        objectMapper.writeValue(response.writer, errorResponse)
    }
}
