package com.tutorials.advices;

import com.tutorials.models.ErrorModel;
import io.jsonwebtoken.JwtException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ApplicationExceptionHandler {

    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorModel> handelMethodArgumentNotValidException(MethodArgumentNotValidException exception) {
        ErrorModel error = new ErrorModel();
        error.setErrorCode("400");
        error.setErrorMessage(exception.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
    }

    @ExceptionHandler(value = JwtException.class)
    public ResponseEntity<ErrorModel> handelJwtException(JwtException exception) {
        ErrorModel error = new ErrorModel();
        error.setErrorCode("403");
        error.setErrorMessage(exception.getMessage());
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(error);
    }

    @ExceptionHandler(value = Exception.class)
    public ResponseEntity<ErrorModel> handelException(Exception exception) {
        ErrorModel error = new ErrorModel();
        error.setErrorCode("500");
        error.setErrorMessage(exception.getMessage());
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(error);
    }

}