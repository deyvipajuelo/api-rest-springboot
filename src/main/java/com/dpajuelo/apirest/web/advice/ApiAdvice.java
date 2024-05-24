package com.dpajuelo.apirest.web.advice;

import com.dpajuelo.apirest.exception.ApiException;
import com.dpajuelo.apirest.web.util.ResponseMessage;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ApiAdvice {

    @ExceptionHandler(value = ApiException.class)
    public ResponseEntity<ResponseMessage<Void>> getException(ApiException exception) {

        ResponseMessage<Void> msg = ResponseMessage.<Void>builder()
                .message(exception.getMessage())
                .build();

        return new ResponseEntity<>(msg, exception.getHttpStatus());
    }

    @ExceptionHandler(value = Exception.class)
    public ResponseEntity<ResponseMessage<Void>> handleGenericException(Exception exception) {
        ResponseMessage<Void> msg = ResponseMessage.<Void>builder()
                .message("An unexpected error occurred")
                .build();
        return new ResponseEntity<>(msg, HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
