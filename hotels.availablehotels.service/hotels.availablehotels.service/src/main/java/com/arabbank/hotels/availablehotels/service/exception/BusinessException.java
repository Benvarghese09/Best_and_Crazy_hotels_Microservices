package com.arabbank.hotels.availablehotels.service.exception;

import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
@NoArgsConstructor
public class BusinessException extends RuntimeException{
    public String ERROR_CODE;
    public BusinessException(String message,String errorCode){
        super(message);
        this.ERROR_CODE=errorCode;

    }
}
