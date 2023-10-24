package com.arabbank.hotels.availablehotels.service.model.dto;

import lombok.Data;

import java.util.ArrayList;

@Data
public class CrazyHotelResponseDto {
    private String hotelName;

    private String hotelRatings;

    private int hotelPrice;

    private ArrayList<String> roomAmenities;

    private int discount;
}
