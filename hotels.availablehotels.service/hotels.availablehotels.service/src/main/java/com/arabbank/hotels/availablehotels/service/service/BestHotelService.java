package com.arabbank.hotels.availablehotels.service.service;

import com.arabbank.hotels.availablehotels.service.feignclient.BestHotelClient;
import com.arabbank.hotels.availablehotels.service.exception.NotFoundException;
import com.arabbank.hotels.availablehotels.service.model.dto.AvailableHotelResponseDto;
import com.arabbank.hotels.availablehotels.service.model.dto.BestHotelResponseDto;
import com.arabbank.hotels.availablehotels.service.model.entity.Provider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BestHotelService {
    @Autowired
    BestHotelClient bestHotelClient;
    List response=new ArrayList<>();

    public List BestHotels(String fromDate, String toDate, String city, int numberOfAdults){
        List<BestHotelResponseDto> bestHotelResponseDtos=bestHotelClient.getHotels(fromDate,toDate,city,numberOfAdults);

        if (bestHotelResponseDtos.isEmpty()){
            throw new NotFoundException("Best Hotel not Found");
        }
        for(BestHotelResponseDto avail:bestHotelResponseDtos) {
            AvailableHotelResponseDto availableHotelResponseDto = new AvailableHotelResponseDto();
            availableHotelResponseDto.setHotelName(avail.getHotelName());
            availableHotelResponseDto.setPrice(avail.getHotelPrice());
            availableHotelResponseDto.setHotelRatings(String.valueOf(avail.getHotelRatings()));
            availableHotelResponseDto.setAmenities(avail.getRoomAmenities());
            availableHotelResponseDto.setProvider(Provider.BEST_HOTEL);

            response.add(availableHotelResponseDto);
        }
        return response;
}
}
