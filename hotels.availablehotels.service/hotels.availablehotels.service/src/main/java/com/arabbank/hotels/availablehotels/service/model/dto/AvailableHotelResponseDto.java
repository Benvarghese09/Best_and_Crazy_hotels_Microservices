package com.arabbank.hotels.availablehotels.service.model.dto;

import com.arabbank.hotels.availablehotels.service.model.entity.Provider;
import lombok.Data;

import java.util.ArrayList;

@Data
public class AvailableHotelResponseDto {
    private Provider provider;
    private String hotelName;
    private int price;
    private String hotelRatings;
    private ArrayList<String> amenities;
}
