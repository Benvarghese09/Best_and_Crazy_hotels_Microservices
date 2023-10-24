package com.arabbank.hotels.availablehotels.service.exception;

import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
@NoArgsConstructor
public class NotFoundException extends BusinessException {
   // public HttpStatus ERROR_CODE=HttpStatus.BAD_REQUEST;
    public NotFoundException(String message){
        super(message,"AC01");
    }

}
