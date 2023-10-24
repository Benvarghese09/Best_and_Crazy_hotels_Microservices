package com.arabbank.hotels.besthotel.service.model.dto;

import lombok.Data;

import java.time.LocalDate;
import java.util.Date;

@Data
public class BestHotelRequestDto {
    private String city;
    private LocalDate fromDate;
    private LocalDate toDate;
    private int numberOfAdults;

}
