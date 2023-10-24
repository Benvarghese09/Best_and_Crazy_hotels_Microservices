package com.arabbank.hotels.besthotel.service.model.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
//import nonapi.io.github.classgraph.json.Id;
//import org.jetbrains.annotations.NotNull;
import nonapi.io.github.classgraph.json.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

@Document(collection = "Best-Hotel-Details")
@Data
@NoArgsConstructor
public class BestHotelEntity {
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
    private int hotelRatings;
    @NonNull
    private int hotelPrice;
    @NonNull
    private ArrayList<String> roomAmenities;


}
