package com.arabbank.hotels.availablehotels.service.feignclient;

import com.arabbank.hotels.availablehotels.service.model.dto.CrazyHotelResponseDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(value ="crazyhotelfeign",url = "${feign.client.crazy-hotel-api.url}")
public interface CrazyHotelClient {
    @GetMapping("/hotel")
    List<CrazyHotelResponseDto> getHotels(@RequestParam String fromDate,@RequestParam String toDate,@RequestParam String city,@RequestParam int numberOfAdults);
}
