package com.arabbank.hotels.availablehotels.service.feignclient;

import com.arabbank.hotels.availablehotels.service.model.dto.BestHotelResponseDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(value = "besthotelfeign",url = "${feign.client.best-hotel-api.url}")
public interface BestHotelClient {
    @GetMapping("/hotel")
    List<BestHotelResponseDto> getHotels(@RequestParam String fromDate, @RequestParam String toDate, @RequestParam String city, @RequestParam int numberOfAdults);


}
