package com.arabbank.hotels.crazyhotel.service.exception;

public class InvalidRateException extends BusinessException{
    public InvalidRateException(String message){
        super(message,"AC033");
    }
}

