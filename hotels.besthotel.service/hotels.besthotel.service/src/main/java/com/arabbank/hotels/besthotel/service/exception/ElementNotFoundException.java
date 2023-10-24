package com.arabbank.hotels.besthotel.service.exception;

import lombok.NoArgsConstructor;


public class ElementNotFoundException extends BusinessException{
    public ElementNotFoundException(String message){
        super(message,"AC03");
    }
}
