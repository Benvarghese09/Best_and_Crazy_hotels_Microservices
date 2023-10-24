package com.arabbank.hotels.crazyhotel.service.controller;

import com.arabbank.hotels.crazyhotel.service.exception.InvalidRateException;
import com.arabbank.hotels.crazyhotel.service.model.dto.ErrorDto;
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
    @ExceptionHandler(value= InvalidRateException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorDto handleInvalidRateException(InvalidRateException ex){
        ErrorDto errorDto=new ErrorDto();
        errorDto.setMessage(ex.getMessage());
        errorDto.setErrorCode(String.valueOf(HttpStatus.BAD_REQUEST));
        log.error(String.valueOf(errorDto));
        return  errorDto;
    }
}
