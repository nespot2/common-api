package com.nespot2.commonapi.common.advice;

import com.nespot2.commonapi.common.api.Code;

/**
 * @author nespot2
 * @version 0.0.1
 * @since 2020/04/19
 **/
public class Nespot2BusinessException extends RuntimeException {

    private Code code;

    public Nespot2BusinessException(Code code) {
        this(code.getMessage());
        this.code = code;
    }

    public Nespot2BusinessException(Code code, String message) {
        this(message);
        this.code = code;
    }

    public Nespot2BusinessException(String message) {
        super(message);
    }

    public Code getCode() {
        return code;
    }
}
