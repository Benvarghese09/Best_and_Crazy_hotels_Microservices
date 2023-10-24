package com.arabbank.hotels.crazyhotel.service.exception;

public class ElementNotFoundException extends BusinessException{
    public ElementNotFoundException(String message){
        super(message,"AC03");
    }
}

