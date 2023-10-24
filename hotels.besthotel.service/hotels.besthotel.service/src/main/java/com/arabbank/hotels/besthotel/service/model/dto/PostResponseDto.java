package com.arabbank.hotels.besthotel.service.model.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import nonapi.io.github.classgraph.json.Id;
import org.jetbrains.annotations.NotNull;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

@NoArgsConstructor
@Data
public class PostResponseDto {
    @Id
    private String id;
    @NotNull
    private String city;
    @NotNull
    private LocalDate fromDate;
    @NotNull
    private LocalDate toDate;
    @NotNull
    private int numberOfAdults;
    @NotNull
    private String hotelName;
    @NotNull
    private int hotelRatings;
    @NotNull
    private int hotelPrice;
    @NotNull
    private ArrayList<String> roomAmenities;
}
