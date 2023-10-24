package com.arabbank.hotels.crazyhotel.service.model.dto;

import lombok.Data;
import lombok.NonNull;

import java.time.LocalDate;

@Data
public class CrazyHotelRequestDto {

    private String city;

    private LocalDate fromDate;

    private LocalDate toDate;

    private int numberOfAdults;
}
