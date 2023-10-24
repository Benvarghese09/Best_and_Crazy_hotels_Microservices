package com.arabbank.hotels.besthotel.service.exception;

public class InvalidRateException extends BusinessException{
    public InvalidRateException(String message){
        super(message,"AC033");
    }
}
