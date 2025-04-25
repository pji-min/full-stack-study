package kr.mooner510.dsmpractice.global.exception

import kr.mooner510.dsmpractice.global.error.exception.CustomException
import kr.mooner510.dsmpractice.global.error.exception.ErrorCode

object JwtException {

    object ExpiredJwtException : CustomException(ErrorCode.EXPIRED_JWT) {
        val EXCEPTION: CustomException = this
    }

    object InvalidJwtException : CustomException(ErrorCode.INVALID_JWT) {
        val EXCEPTION: CustomException = this
    }
}
