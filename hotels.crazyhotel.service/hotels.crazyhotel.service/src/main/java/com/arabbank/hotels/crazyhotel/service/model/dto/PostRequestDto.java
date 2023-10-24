package com.arabbank.hotels.crazyhotel.service.model.dto;

import lombok.Data;
import lombok.NonNull;
import nonapi.io.github.classgraph.json.Id;
import org.springframework.data.mongodb.core.index.Indexed;

import java.time.LocalDate;
import java.util.ArrayList;

@Data
public class PostRequestDto {
    @Id
    private String id;
    @NonNull
    private String city;
    @NonNull
    private LocalDate fromDate;
    @NonNull
    private LocalDate toDate;
    @NonNull
    private int numberOfAdults;
    @NonNull
    @Indexed(unique = true)
    private String hotelName;
    @NonNull
    private String hotelRatings;
    @NonNull
    private int hotelPrice;
    @NonNull
    private ArrayList<String> roomAmenities;
    @NonNull
    private int discount;
}
