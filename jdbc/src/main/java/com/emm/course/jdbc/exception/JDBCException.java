package com.emm.course.jdbc.exception;

public class JDBCException extends RuntimeException {
    public JDBCException(String message, Throwable cause) {
        super(message, cause);
    }
}
