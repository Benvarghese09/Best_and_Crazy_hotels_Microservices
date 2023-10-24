package com.arabbank.hotels.besthotel.service.controller;

import com.arabbank.hotels.besthotel.service.exception.BusinessException;
import com.arabbank.hotels.besthotel.service.exception.ElementNotFoundException;
import com.arabbank.hotels.besthotel.service.exception.InvalidRateException;
import com.arabbank.hotels.besthotel.service.model.dto.ErrorDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@ControllerAdvice
@RestController
public class BestHotelExceptionController {
    @ExceptionHandler(value= BusinessException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorDto handleInvalidRateException(BusinessException ex){
        ErrorDto errorDto=new ErrorDto();
        errorDto.setMessage(ex.getMessage());
        errorDto.setErrorCode(String.valueOf(ex.ERROR_CODE));
        log.error(String.valueOf(errorDto));
        return  errorDto;
    }

}
