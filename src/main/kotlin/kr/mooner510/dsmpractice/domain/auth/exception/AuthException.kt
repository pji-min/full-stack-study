package kr.mooner510.dsmpractice.domain.auth.exception

import kr.mooner510.dsmpractice.global.error.exception.CustomException
import kr.mooner510.dsmpractice.global.error.exception.ErrorCode

object AuthException {

    object InvalidRefreshTokenException : CustomException(ErrorCode.INVALID_REFRESH_TOKEN) {
        val EXCEPTION: CustomException = this
    }

    object PasswordMisMatchException : CustomException(ErrorCode.PASSWORD_MISMATCH) {
        val EXCEPTION: CustomException = this
    }

    object RefreshTokenNotFoundException : CustomException(ErrorCode.REFRESH_TOKEN_NOT_FOUND) {
        val EXCEPTION: CustomException = this
    }
}
