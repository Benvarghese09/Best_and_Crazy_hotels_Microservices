package com.arabbank.hotels.besthotel.service.model.dto;

import lombok.Data;
import lombok.NonNull;
import org.jetbrains.annotations.NotNull;
import org.springframework.data.mongodb.core.index.Indexed;

import java.time.LocalDate;
import java.util.ArrayList;

@Data
public class BestHotelUpdateDto {
    private String hotelName;
    private int hotelPrice;

    private String city;

    private LocalDate fromDate;

    private LocalDate toDate;

    private int numberOfAdults;

    private int hotelRatings;


    private ArrayList<String> roomAmenities;



}
