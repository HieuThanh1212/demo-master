package com.vmo.springboot.Demo.configuration;

import com.vmo.springboot.Demo.dto.Respone.ResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
@ControllerAdvice
public class common {
    @ExceptionHandler()
    public ResponseEntity handleException(Exception e) {
        ResponseDto apiResponse = new ResponseDto();
        apiResponse.setError(e.getLocalizedMessage());
        apiResponse.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR.value()).body(apiResponse);
    }
}
