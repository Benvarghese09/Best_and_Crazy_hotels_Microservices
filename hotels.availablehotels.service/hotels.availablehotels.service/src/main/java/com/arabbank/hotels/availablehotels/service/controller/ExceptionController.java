package com.arabbank.hotels.availablehotels.service.controller;

import com.arabbank.hotels.availablehotels.service.exception.BusinessException;
import com.arabbank.hotels.availablehotels.service.model.dto.ErrorDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestControllerAdvice
public class ExceptionController {
    @ExceptionHandler(value= BusinessException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)

    public ErrorDto handleInvalidRateException(BusinessException ex){
        log.error("We have Service exception", ex);
        ErrorDto errorDto=new ErrorDto();
        errorDto.setMessage(ex.getMessage());
        errorDto.setErrorCode(String.valueOf(ex.ERROR_CODE));

        return  errorDto;
    }




}
