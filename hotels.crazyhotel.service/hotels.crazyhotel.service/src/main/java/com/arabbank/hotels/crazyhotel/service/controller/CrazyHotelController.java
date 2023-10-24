package com.arabbank.hotels.crazyhotel.service.controller;

import com.arabbank.hotels.crazyhotel.service.model.dto.CrazyHotelRequestDto;
import com.arabbank.hotels.crazyhotel.service.model.dto.CrazyHotelResponseDto;
import com.arabbank.hotels.crazyhotel.service.model.dto.CrazyHotelUpdateDto;
import com.arabbank.hotels.crazyhotel.service.model.dto.PostRequestDto;
import com.arabbank.hotels.crazyhotel.service.service.CrazyHotelService;
import com.mongodb.client.result.DeleteResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
public class CrazyHotelController {
    @Autowired
    private CrazyHotelService crazyHotelService;

    @GetMapping("/hotel")
    public List<CrazyHotelResponseDto> getCrazyHotelByCityDateAndNumber(@RequestParam String city, @RequestParam String fromDate,@RequestParam String toDate,@RequestParam int numberOfAdults)throws Exception{
        LocalDate fromDateParse=LocalDate.parse(fromDate.trim());
        LocalDate toDateParse=LocalDate.parse(toDate.trim());
        return crazyHotelService.getCrazyHotelByCityDateAndNumber(city,fromDateParse,toDateParse,numberOfAdults);
    }
    @PostMapping("/create-hotel")
    public CrazyHotelResponseDto createHotel(@RequestBody PostRequestDto postRequestDto)throws Exception{
        return crazyHotelService.createHotel(postRequestDto);
    }
    @PatchMapping("/edit-crazy-hotel")
    public String editBestHotelsWithFields(@RequestBody CrazyHotelUpdateDto bestHotelUpdateDto)throws  Exception{
        return crazyHotelService.editHotel(bestHotelUpdateDto);
    }
    @PutMapping("/edit-hotel")
    public String editAllBestHotel(@RequestBody CrazyHotelUpdateDto crazyHotelUpdateDto)throws Exception{
        return crazyHotelService.editAllHotel(crazyHotelUpdateDto);
    }

    @DeleteMapping("/delete-hotel")
    public DeleteResult deleteTheHotel(@RequestBody CrazyHotelUpdateDto crazyHotelUpdateDto)throws Exception{
        return crazyHotelService.deleteHotel(crazyHotelUpdateDto);
    }



}
