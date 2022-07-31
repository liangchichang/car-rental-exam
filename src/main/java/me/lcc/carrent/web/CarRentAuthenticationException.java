package me.lcc.carrent.web;

import org.springframework.security.core.AuthenticationException;

/**
 * @author lcc
 * @version 2022/7/30
 */
public class CarRentAuthenticationException extends AuthenticationException {

    public CarRentAuthenticationException(String msg, Throwable cause) {
        super(msg, cause);
    }

    public CarRentAuthenticationException(String msg) {
        super(msg);
    }
}
