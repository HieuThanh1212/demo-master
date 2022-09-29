package com.vmo.springboot.Demo.utilities;

import com.vmo.springboot.Demo.dto.Respone.ResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class ResponeUltil {
    public ResponseEntity<ResponseDto> getSuccessResponse(Object responseData) {
        return new ResponseEntity<>(new ResponseDto(
                HttpStatus.OK.value(), HttpStatus.OK.getReasonPhrase(), responseData), HttpStatus.OK);
    }
    public ResponseEntity<ResponseDto> getSuccessResponse() {
        return new ResponseEntity<>(new ResponseDto(
                HttpStatus.OK.value(), HttpStatus.OK.getReasonPhrase()), HttpStatus.OK);
    }
    public ResponseEntity<ResponseDto> getBadRequestResponse(Object message) {
        return new ResponseEntity<>(new ResponseDto(
                HttpStatus.BAD_REQUEST.value(), message), HttpStatus.BAD_REQUEST);
    }
    public ResponseEntity<ResponseDto> getInternalServerErrorResponse() {
        return new ResponseEntity<>(new ResponseDto(HttpStatus.INTERNAL_SERVER_ERROR.value(), HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase()),
                HttpStatus.INTERNAL_SERVER_ERROR );
    }
}
