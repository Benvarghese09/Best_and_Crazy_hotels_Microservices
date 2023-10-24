package com.arabbank.hotels.crazyhotel.service.model.dto;

import lombok.Data;
import lombok.NonNull;
import org.springframework.data.mongodb.core.index.Indexed;

import java.time.LocalDate;
import java.util.ArrayList;

@Data
public class CrazyHotelUpdateDto {
    @Indexed(unique = true)
    private String hotelName;
    private String hotelPrice;
    private String city;

    private LocalDate fromDate;

    private LocalDate toDate;

    private int numberOfAdults;

    private String hotelRatings;


    private ArrayList<String> roomAmenities;

    private int discount;
}
