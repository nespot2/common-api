package com.nespot2.commonapi.common.advice;

import com.nespot2.commonapi.common.api.ApiResult;
import com.nespot2.commonapi.common.api.Code;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * @author nespot2
 * @version 0.0.1
 * @since 2020/03/08
 **/
@ControllerAdvice
public class GlobalControllerAdvice {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ApiResult> handlerException(MethodArgumentNotValidException e) {
        StringBuilder sb = new StringBuilder();
        sb.append("Invalid Parameter(s): ");

        for (ObjectError objectError : e.getBindingResult().getAllErrors()) {
            sb.append(objectError.getCode()+" ");
        }

        return ResponseEntity.badRequest().body(ApiResult.fail(Code.BAD_REQUEST, sb.toString()));
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiResult> exceptionHandler(Exception e) {
        return ApiResult.fail(Code.ERROR, e.getMessage()).createResponseEntity();
    }

    @ExceptionHandler(Nespot2BusinessException.class)
    public ResponseEntity<ApiResult> businessException(Nespot2BusinessException e) {
        return ApiResult.fail(e.getCode(), e.getCode().getMessage()).createResponseEntity();
    }
}
