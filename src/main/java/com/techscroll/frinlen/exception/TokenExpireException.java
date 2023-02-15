package com.techscroll.frinlen.exception;

import org.springframework.security.core.AuthenticationException;

public class TokenExpireException extends AuthenticationException {
    public TokenExpireException(String msg) {
        super(msg);
    }
}
