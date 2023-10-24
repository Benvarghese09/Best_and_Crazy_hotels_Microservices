package com.arabbank.hotels.availablehotels.service.controller;

import com.arabbank.hotels.availablehotels.service.model.dto.AvailableHotelRequestDto;
import com.arabbank.hotels.availablehotels.service.model.dto.AvailableHotelResponseDto;
import com.arabbank.hotels.availablehotels.service.model.entity.Provider;
import com.arabbank.hotels.availablehotels.service.service.AvailableHotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

@RestController
public class AvailableHotelController {
    @Autowired
    private AvailableHotelService availableHotelService;
    @GetMapping ("/hotel")
    public List getAvailableHotelsByDateCityAndNumber(@RequestParam String fromDate,@RequestParam String toDate,@RequestParam String city,@RequestParam int numberOfAdults){

        return availableHotelService.getBestHotels(fromDate,toDate,city,numberOfAdults);

    }
}
