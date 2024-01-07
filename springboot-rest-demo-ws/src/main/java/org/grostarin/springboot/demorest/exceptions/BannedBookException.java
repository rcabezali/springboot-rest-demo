package org.grostarin.springboot.demorest.exceptions;

// New exception for when a Book is banned

public class BannedBookException extends RuntimeException {

    public BannedBookException() {
        super();
    }

    public BannedBookException(final String message, final Throwable cause) {
        super(message, cause);
    }

    public BannedBookException(final String message) {
        super(message);
    }

    public BannedBookException(final Throwable cause) {
        super(cause);
    }
}