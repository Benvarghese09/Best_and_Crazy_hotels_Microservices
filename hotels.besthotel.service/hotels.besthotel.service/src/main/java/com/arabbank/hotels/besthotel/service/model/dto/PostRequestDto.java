package com.arabbank.hotels.besthotel.service.model.dto;

import lombok.Data;
import nonapi.io.github.classgraph.json.Id;
import org.jetbrains.annotations.NotNull;
import org.springframework.data.mongodb.core.index.Indexed;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

@Data
public class PostRequestDto {
    @Id
    private String id;

    private String city;

    private LocalDate fromDate;

    private LocalDate toDate;

    private int numberOfAdults;

    @Indexed(unique = true)
    private String hotelName;

    private int hotelRatings;

    private int hotelPrice;

    private ArrayList<String> roomAmenities;

}
