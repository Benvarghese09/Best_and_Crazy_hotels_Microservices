package com.arabbank.hotels.besthotel.service.exception;

import springfox.documentation.oas.mappers.StyleEnumMapperImpl;

public class BusinessException extends RuntimeException{
    public String ERROR_CODE;
    public BusinessException(String message,String errorCode){
        super(message);
        this.ERROR_CODE=errorCode;
    }
}
