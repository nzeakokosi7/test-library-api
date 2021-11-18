package com.example.libraryApi.common.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class NotFoundException extends RuntimeException{
    final String message;
    public NotFoundException(String message) {
        super(message);
        this.message = message;
    }

    public NotFoundException(String message, Exception exception) {
        super(message, exception);
        this.message = message;
    }

}
