package com.arabbank.hotels.besthotel.service.model.dto;

import lombok.Data;

import java.util.ArrayList;

@Data
public class BestHotelResponseDto {
    private String hotelName;
    private int hotelRatings;
    private int hotelPrice;
    private ArrayList<String> roomAmenities;
}
