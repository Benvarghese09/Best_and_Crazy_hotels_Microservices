package com.arabbank.hotels.besthotel.service.controller;

import com.arabbank.hotels.besthotel.service.model.dto.BestHotelRequestDto;
import com.arabbank.hotels.besthotel.service.model.dto.BestHotelResponseDto;
import com.arabbank.hotels.besthotel.service.model.dto.BestHotelUpdateDto;
import com.arabbank.hotels.besthotel.service.model.dto.PostRequestDto;
import com.arabbank.hotels.besthotel.service.service.BestHotelService;
import com.mongodb.client.result.DeleteResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
public class BestHotelController {
    @Autowired
    private BestHotelService bestHotelService;
    @GetMapping("/hotel")
    public List<BestHotelResponseDto> getBestHotelsByCityDateAndNumber(@RequestParam String city,@RequestParam String fromDate,@RequestParam String toDate,@RequestParam int numberOfAdults)throws Exception{
        LocalDate fromDateParse=LocalDate.parse(fromDate.trim());
        LocalDate toDateParse=LocalDate.parse(toDate.trim());
        return bestHotelService.getBestHotelByCityDateAndNumber(city,fromDateParse,toDateParse,numberOfAdults);


    }
    @PostMapping("/create-hotel")
    public BestHotelResponseDto createHotel(@RequestBody PostRequestDto postRequestDto)throws Exception{
        return bestHotelService.createHotel(postRequestDto);
    }

    @PatchMapping("/edit-best-hotel")
    public String editBestHotelsWithFields(@RequestBody BestHotelUpdateDto bestHotelUpdateDto)throws  Exception{
       return bestHotelService.editHotel(bestHotelUpdateDto);
    }

    @PutMapping("/edit-hotel")
    public String editAllBestHotel(@RequestBody BestHotelUpdateDto bestHotelUpdateDto)throws Exception{
        return bestHotelService.editAllHotel(bestHotelUpdateDto);
    }

    @DeleteMapping("/delete-hotel")
    public DeleteResult deleteTheHotel(@RequestBody BestHotelUpdateDto bestHotelUpdateDto)throws Exception{
        return bestHotelService.deleteHotel(bestHotelUpdateDto);
    }


}
