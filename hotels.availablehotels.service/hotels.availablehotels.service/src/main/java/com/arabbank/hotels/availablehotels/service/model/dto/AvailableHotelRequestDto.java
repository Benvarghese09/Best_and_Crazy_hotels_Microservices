package com.arabbank.hotels.availablehotels.service.model.dto;

import lombok.Data;

import java.time.LocalDate;
import java.util.Date;

@Data
public class AvailableHotelRequestDto {
    private String fromDate;
    private String toDate;
    private String city;
    private int numberOfAdults;
}
