package com.ezms.project.exceptions.handlers;

import com.ezms.project.exceptions.NotFoundException;
import com.ezms.project.exceptions.dto.DefaultExceptionDTO;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.PropertyValueException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@Slf4j
@RestControllerAdvice
public class AppExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler({PropertyValueException.class, NullPointerException.class})
    public ResponseEntity<Object> handleNonNullFields(Exception e) {
        DefaultExceptionDTO error = new DefaultExceptionDTO(
                HttpStatus.BAD_REQUEST.value(), "The request has missing or null fields", e.getMessage()
        );

        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler({NotFoundException.class})
    public ResponseEntity<Object> handleNotFound(Exception e) {
        DefaultExceptionDTO error = new DefaultExceptionDTO(HttpStatus.NOT_FOUND.value()
                , e.getMessage()
                ,"No data found" +
                ", please make sure you are using the correct database or there is data in the database");

        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }
}
