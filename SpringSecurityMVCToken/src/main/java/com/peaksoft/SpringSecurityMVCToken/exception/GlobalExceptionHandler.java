package com.peaksoft.SpringSecurityMVCToken.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErrorDTO> handleResourceNotFoundException(ResourceNotFoundException exception,
                                                                    WebRequest request) {
        ErrorDTO errorDTO = new ErrorDTO(new Date(), exception.getMessage(),
                request.getDescription(false));
        return new ResponseEntity<>(errorDTO, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(MyException.class)
    public ResponseEntity<ErrorDTO> handleMyException(MyException exception, WebRequest request) {
        ErrorDTO errorDTO = new ErrorDTO(new Date(), exception.getMessage(),
                request.getDescription(false));
        return new ResponseEntity<>(errorDTO, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorDTO> handleGlobalException(Exception exception, WebRequest request) {
        ErrorDTO errorDTO = new ErrorDTO(new Date(), exception.getMessage(),
                request.getDescription(false));
        return new ResponseEntity<>(errorDTO, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}

