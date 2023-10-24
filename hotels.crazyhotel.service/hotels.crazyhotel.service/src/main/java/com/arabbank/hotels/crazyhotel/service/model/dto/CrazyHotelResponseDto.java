package com.arabbank.hotels.crazyhotel.service.model.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.util.ArrayList;

@Data
public class CrazyHotelResponseDto {

    private String hotelName;

    private String hotelRatings;

    private int hotelPrice;

    private ArrayList<String> roomAmenities;

    private int discount;
}
