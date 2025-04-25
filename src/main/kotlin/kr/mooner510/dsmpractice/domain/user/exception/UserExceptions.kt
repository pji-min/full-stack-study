package kr.mooner510.dsmpractice.domain.user.exception

import kr.mooner510.dsmpractice.global.error.exception.CustomException
import kr.mooner510.dsmpractice.global.error.exception.ErrorCode

object UserNotFoundException : CustomException(ErrorCode.USER_NOT_FOUND)

object UserExistException : CustomException(ErrorCode.USER_EXISTS)
