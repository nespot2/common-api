package com.nespot2.commonapi.common.advice;

import com.nespot2.commonapi.common.api.ApiResult;
import com.nespot2.commonapi.common.api.Code;
import com.nespot2.commonapi.member.exception.NotFoundMemberException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * @author nespot2
 * @version 0.0.1
 * @since 2020/03/08
 **/
@ControllerAdvice
public class BusinessControllerAdvice {

    @ExceptionHandler(NotFoundMemberException.class)
    public ResponseEntity<ApiResult> notFoundMemberException(NotFoundMemberException e) {
        return ApiResult.fail(Code.NOT_FOUND_MEMBER, e.getMessage()).createResponseEntity();
    }

}
