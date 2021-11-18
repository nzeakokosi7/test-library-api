package com.example.libraryApi.common.exceptions;

import com.example.libraryApi.common.dtos.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Arrays;
import java.util.Objects;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(NotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<ErrorResponse> handleNoSuchElementFoundException(NotFoundException exception, WebRequest request) {
        return buildErrorResponse(exception, request);
    }

    private ResponseEntity<ErrorResponse> buildErrorResponse(
            Exception exception,
            WebRequest request
    ) {
        ErrorResponse errorResponse = new ErrorResponse(
                HttpStatus.NOT_FOUND.value(),
                exception.getLocalizedMessage(),
                request.getDescription(false)
        );

        if(isTraceOn(request)){
            errorResponse.setStackTrace(Arrays.toString(exception.getStackTrace()));
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
    }

    private boolean isTraceOn(WebRequest request) {
        String [] value = request.getParameterValues("trace");
        return Objects.nonNull(value)
                && value.length > 0
                && value[0].contentEquals("true");
    }
}
