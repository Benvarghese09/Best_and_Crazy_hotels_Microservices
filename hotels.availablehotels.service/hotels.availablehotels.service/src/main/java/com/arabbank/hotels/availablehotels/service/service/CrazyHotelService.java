package com.arabbank.hotels.availablehotels.service.service;

import com.arabbank.hotels.availablehotels.service.feignclient.CrazyHotelClient;
import com.arabbank.hotels.availablehotels.service.exception.NotFoundException;
import com.arabbank.hotels.availablehotels.service.model.dto.AvailableHotelResponseDto;
import com.arabbank.hotels.availablehotels.service.model.dto.CrazyHotelResponseDto;
import com.arabbank.hotels.availablehotels.service.model.entity.Provider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CrazyHotelService {
    @Autowired
    private CrazyHotelClient crazyHotelClient;
    List responses=new ArrayList<>();
    public List CrazyHotels(String fromDate, String toDate, String city, int numberOfAdults){
        List<CrazyHotelResponseDto> crazyHotelResponseDtos=crazyHotelClient.getHotels(fromDate,toDate,city,numberOfAdults);
        if (crazyHotelResponseDtos.isEmpty()){
            throw new NotFoundException("Crazy Hotel not Found");
        }
        for(CrazyHotelResponseDto crazyavail:crazyHotelResponseDtos){
            AvailableHotelResponseDto availableHotelResponseDto=new AvailableHotelResponseDto();
            availableHotelResponseDto.setHotelName(crazyavail.getHotelName());
            availableHotelResponseDto.setPrice(crazyavail.getHotelPrice());
            availableHotelResponseDto.setHotelRatings(String.valueOf(String.valueOf(crazyavail.getHotelRatings()).length()));
            availableHotelResponseDto.setAmenities(crazyavail.getRoomAmenities());
            availableHotelResponseDto.setProvider(Provider.CRAZY_HOTEL);
            responses.add(availableHotelResponseDto);
        }
        return responses;
    }
}
