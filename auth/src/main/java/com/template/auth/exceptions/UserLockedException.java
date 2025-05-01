package com.template.auth.exceptions;

public class UserLockedException extends RuntimeException {
    public UserLockedException(String message) {
        super(message);
    }
}
